SVG :

Basic Shapes :
	1. Line
	2. Path
	
	
	
Notes:

Steps to generate a path.
	1. Define data : Select two properties from data object which can be mapped to x axis and y axis.
	2. Define scales (linear/ordinal) with domain and range specified.
	3. Define line generator : which generates the path based on input data.
	4. Append path element to svg with 'd' attribute defined.
	
Path Generator Syntax(es):
1. Line Generator :d3.svg.line()
		.x(function (d) { return d.x; })
		.y(function(d) { return d.y;})

	Usage :
	svg.append('path')
	.datum(data)
	.attr({
		'd': generator,
		'fill': 'none',
		'stroke': 'steelblue'
	})

2. Area Generator:
	var area = d3.svg.area()
			.y0(100)
			.x(function(d) { return x(d.x); })
			.y1(function(d) { return y(d.y); });
	Usage :
	svg.append('path')
		.attr({
			'd': area(data),
			fill: 'yellow',
			stroke: '#ccc',
			'stroke-width': 2,
			'opacity': 0.5
		});

3. Arc Generator:
	var arc = d3.svg.arc()
	.innerRadius(100)
	.outerRadius(200)
	.startAngle(0)
	.endAngle(Math.PI * 2);

	Usage :
	svg.append('path')
		.attr({
			'd': arc,
			fill: 'yellow',
			transform: 'translate(200, 200)',
			stroke: '#ccc',
			'stroke-width': 2,
			'opacity': 0.5
		});

Another usage of Arc is that, by changing just startAngle and endAngle , we can create pie piece shapes.
Example:

	var arc = d3.svg.arc()
			.innerRadius(0)
			.outerRadius(200)
			.startAngle(45 * Math.PI  * 2 / 360) // Change the start angle and endAngle to create different arcs.
			.endAngle(75 * Math.PI  * 2 / 360);

4. Pie Generator:
	var arcGenerator = d3.svg.arc()
		.innerRadius(0)
		.outerRadius(100)
		.startAngle(function(d) {
		return d.startAngle;
		})
		.endAngle(function(d) {
		return d.endAngle;
		});
	Usage :

	svg.selectAll('path')
		.data(pieSegments) // 1. Specify the Pie Segments.
		.enter()
		.append('path')
		.attr('d', arcGenerator) // 2. Specify the arcGenerator , that is pie generator.
		.attr('transform', 'translate(100,100)')
		.style('fill', function(d, i) { //Specify the colors for each pie.
			return colors(i);
		});

5. Symbol Generator:
D3 API supports to generate 6 types of symbols. They are : "circle", "cross", "diamond", "square", "triangle-down", "triangle-up"
They are defined in d3.svg.symbolTypes.
The symbols can be generated using path.


