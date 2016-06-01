#Chord Layout:
Chord Layout is useful to display the relation within groups.
	High Level Overview : In a High level, chord diagram is useful to display data to show relations between groups.
		The data for chord diagram is a m X m matrix(equal number of rows and columns).
		We use d3.layout.chord() to generate a chord layout, by giving the data as input to the matrix function.

		Next, we need to perform the below things.
		-> Display groups using path and arc.(needed innerRadius, colors, outerRadius) . The colors array should be equal to the number of groups.
		-> Display the relations in the form of paths by using the chords function of the layout object. Here also we need to give the colors.
		-> Last, we need to display labels for each group.

	Syntax : d3.layout.chord().matrix(matrix); //Here matrix is a multi dimentional array.
	It returns an object which has the below properties:
		-> chords: An array of source & target pairs.
		-> groups: Groups made out of the matrix to display the data.
		-> matrix
		-> padding : Specifies the padding between groups.
		-> sortChords
		-> sortGroups
		-> sortSubGroups.

	To Create the chord layout, first we need to display the groups using arcs. That can be done using the below code.

	// Creates color array.
	var fill = d3.scale.ordinal().domain(d3.range(4))
		.range(['#000000', '#FFEE89', '#957244', '#FF0023']);

		var innerRadius = Math.min(width, height) * 0.41, // specifies the innerRadius based on the minimum dimention of the svg container
		outerRadius = innerRadius * 1.1; // specifies the outerRadius relative to innerRadius
		mainGroup.append('g')
		.selectAll('path')
		.data(layout.groups) // This will set the input data for the number of groups.
		.enter()
		.append('path')
		.style('fill', function(d) { return fill(d.index); })
		.style('stroke', function(d) { return fill(d.index); })
		.attr('d', d3.svg.arc()
		.innerRadius(innerRadius)
		.outerRadius(outerRadius));
	Next, the chords are rendered. A d3.svg.chord() function will be applied to each
	datum, and a path of the size innerRadius is generated:

	mainGroup.append('g')
	.selectAll('path')
	.data(layout.chords)
	.enter()
	.append('path')
	.attr('d', d3.svg.chord()
	.radius(innerRadius))
	.style('fill', function(d) { return fill(d.target.index); })
	.style({
		opacity: 1,
		stroke: '#000',
		'fill-opacity': 0.67,
		'stroke-width': '0.5px'
	});

	Generating Ticks:
	Ticks can be generated in three steps.
		1. Generate the angle & label for each tick relative to the group. This can be done by using the below function.
			function groupTicks (d) {
				var tickLength = (d.endAngle - d.startAngle) / d.value;
				return d3.range(0, d.value, 10).map(function (v, i) {
					return {
						angle: v * tickLength + d.startAngle,
						label: i % 2 ? null : v
					}
				})
			};
		  Description : The above function takes a group(d) and calculates the width in angles and relates the width to value. That is assigned to tickLength. Now, we are generating more than one tick in multiples of 10. that will be done by d3.range(0, d.value, 10).
		  
		  d3.range(0, d.value, 10). : Meaning, it returns an array of values in multiples of 10 between 0 and d.value.
		  We are iterating the given array and generating equal number of objects which has angle and label . This array is the source for generating ticks and labels.
		  
		  Next, we need to add the enough number of 'g' for the generated ticks.
		  
		  that can be done below.

		  var ticks = mainGroup.append('g') // Adds a new group
				.selectAll('g')
				.data(chord.groups) // data for each group
				.enter().append('g') // adds 'g' to the main group based on chord.groups length
				.selectAll('g')
				.data(groupTicks) // used to generate ticks, here it is useful to generate enough 'g's
				.enter()
				.append('g') // add one 'g' per tick
				.attr('transform', function (d) { // rotates relative to the tick's angle.
                return 'rotate(' + (d.angle * 180 / Math.PI - 90) + ')'
                    + 'translate(' + outerRadius + ',0)';
            });
		  
		Now we have added enough gs. So, next we need to generate ticks using line.
		
		The below code generates ticks. As we know, the coordinate system inside a g is relative to g, so, here we are generating a line with coords (1,0) to (5,0).  
		ticks.append('line')
			.attr({
                x1: 1, y1: 0,
                x2: 5, y2: 0,
                stroke: 'black'
            });

		Now what is left is : to display the values. Remember, the values will be generated using groupTicks method.
		We can add a text to each tick using the below method.

		// The below code displays the labels.
		ticks.append('text')
            .attr({
                'x': 8,
                'dy': '.35em',
                'transform': function (d) { return d.angle > Math.PI ? 'rotate(180)translate(-16)' : null; }
            })
            .style('text-anchor', function (d) { return d.angle > Math.PI ? 'end' : null; })
            .style('font', '10px sans-serif')
            .text(function (d) { return d.label; });

		Now , last but not the least, we need to display the chords.
		Chords are the paths, which are drawn from source to target.
		
		Chords can be added to svg diagram using chord.chords property.
		Add a new group to main group, and add paths for each chord and fill with target index.
		The code is below.

		mainGroup.append('g')
			.selectAll('path') 
			.data(chord.chords) // data for chords
			.enter()
			.append('path') // Adds a path
			.attr('d', d3.svg.chord().radius(innerRadius)) // Specifies the d property of the path.
			.attr('fill', function (d) { return fill(d.target.index); });
		