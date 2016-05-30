The available D3 Layouts:

 1. Bundle Layout.
 2. Chord layout
 3. Cluster Layout
 4. Force layout
 5. Hierarchy Layout
 6. Histogram
 7. Pack Layout
 8. Partition Layout
 9. Pie Layout
10. Stack Layout
11. Tree Layout
12. Treemap Layout

#Bundle Layout:
To define a bundle layout :
	d3.layout.bundle()
	

#Cluster Layout:

	High Level Overview : Cluster layout is useful to visualize hierarchical data. The cluster layout takes the data which is in hirarchical form and, contains methods to generate links(paths) and display the data as nodes. The nodes contains links in a hierarchical fashion. Another important point is, we need to specify(or design) how the data is displayed(for ex: whether in a radical form using circular coordinates, or a normal form)

	The important points in designing a cluster layout is :
		-> Size - specifies how we display the data.(with coordiante values)
		-> Nodes - the nodes of the hierarchy.
		-> Links - The connections between nodes.

	Cluster Layout is a kind of hierarchical layout.
	Syntax : d3.layout.cluster()
	Description : 
		-> Creates a default cluster layout
		-> Default sort order null
		-> The default child accessor assumes that each node in the data contains a children array.

	The available cluster layout functions:
		a) nodes - Runs the cluster layout, returning the array of nodes associated with the specified root node. The cluster layout is part of D3's family of hierarchical layouts. These layouts follow the same basic structure: the input argument to the layout is the root node of the hierarchy, and the output return value is an array representing the computed positions of all nodes. Several attributes are populated on each node:

			-> parent - the parent node, or null for the root.
			-> children - the array of child nodes, or null for leaf nodes.
			->depth - the depth of the node, starting at 0 for the root.
			-> x - the computed x-coordinate of the node position.
			-> y - the computed y-coordinate of the node position.
		
		Although the layout has a size in x and y, this represents an arbitrary coordinate system; for example, you can treat x as a radius and y as an angle to produce a radial rather than Cartesian layout.

		b) links - Given the specified array of nodes, such as those returned by nodes, returns an array of objects representing the links from parent to child for each node. Leaf nodes will not have any links. Each link is an object with two attributes:

			source - the parent node (as described above).
			target - the child node.
			This method is useful for retrieving a set of link descriptions suitable for display, often in conjunction with the diagonal shape generator. For example:
				Code : svg.selectAll("path")
				.data(cluster.links(nodes))
				.enter().append("path")
				.attr("d", d3.svg.diagonal());

		c) size - 
			-> Description :If size is specified, sets the available layout size to the specified two-element array of numbers representing x and y. If size is not specified, returns the current size, which defaults to 1×1, or null if a nodeSize is in use. Although the layout has a size in x and y, this represents an arbitrary coordinate system. For example, to produce a radial layout where the tree breadth (x) in measured in degrees, and the tree depth (y) is a radius r in pixels, say [360, r].
