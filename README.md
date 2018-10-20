# MST_Kruskal
This is the implementation of Kruskal Algorithm of Minimum Spanning Tree using disjoint set and heap data structures. 

Usage: Feel free to modify MST_Driver.java file. Suppose that the input graph file is graph1.txt.
        MST_Kruskal mst = new MST_Kruskal(); 
        ArrayList<Node<Vertex>> arrList = mst.initialzation(g, "graph1.txt");
        ArrayList<Arc> result = mst.execute(g, "graph1.txt");
        
Then result is a pointer to an array list containing all the arcs for the MST. 
        
        
Input format for graph1.txt:
(1) The only number in the first line is the total number of vertices in the input graph.
(2) List all the vertices, one each line, starting from the second line.
(3) List all the edges(arcs) with their weights associated with, one arc per line, starting from the first line after the last vertex.

Please refer to graph1.txt as an example for the input graph file. 
