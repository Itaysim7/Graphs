This repository represents a graph and some algorithms that can be done on it, and a GUI class that can draws the graph and its algorithms.

nodeData represents a vertex in the graph.
it has those variables:
int nextID: represents the node id.
Point3D location: represents the location for the draw.
int key: represent the "name" of the node.
double weight: represent the node weight for the algorithm.
String info: represent the node parent for the algorithm.
int tag: represent the node color for the algorithm. 0-means white. 1-means grey. 2-means black.
a builder and get and set function for all this variable.

edgeData represents a edge in the graph.
it has those variables:
int src: the source of the edge.
int dest: the destination of the edge.
double weight: the weight of the edge.
String info: not yet been used. can be used for the benefit of functions.
int tag: the color of the edge.
a builder and get and set function for all this variable.

Dgraph represents the graph.
has two hashmaps that represents the vertices and the edges, count of the adge and count of changes. has an empty builder
it can do:
gets vertex, gets edge, gets all vartices and gets all edge of a given vertex.
connects 2 vertices.
removes edge or vertex.
gets how many edges or vertices there are.
gets how many changes the graph been threw.

Graph_Algo represents some algorithms that can be done on the graph.
has a variable graph that we will do the algorithms on.
function:
init in given graph or file.
save graph to file.
copy the graph.
TSP given list of targets
isConnected
two shortestPath function given source and dastionation, one returns the weight and one returns the list of targets.



