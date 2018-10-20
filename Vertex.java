/**
 * Adjacency linked lists representation of a vertex in a graph.  
 */
public class Vertex {
    
	/**
	 * Inner class - represents a neighbor (an outgoing edge) in a weighted graph.
	 */
	public static class Neighbor {
	    
		/**
	     * Neighboring vertex.
	     */
	    public Vertex vertex;
	    
	    /**
	     * Weight of edge to neighbor.
	     */
	    public int weight;
	    
	    /**
	     * Next neighbor in the linked list of neighbors.
	     */
	    public Neighbor next;

	    /**
	     * Initializes a new Neighbor object.
	     * 
	     * @param vertex Neighbor vertex
	     * @param weight Weight of edge to neighbor.
	     */
	    Neighbor(Vertex vertex, int weight) {
	    	this.vertex = vertex;
	    	this.weight = weight;
	    }
	}
	
	/**
     * Name of this vertex.
     */
    public String name;

    /**
     * Adjacency linked list of all neighbors.
     */
    public Neighbor neighbors;
    

   
    /**
     * Constructs a new Vertex object with no neighbors (i.e.,
     * no outgoing edges), and no parent vertex (i.e., it is its own partial
     * spanning tree).
     * @param name Name to give to this vertex.
     */
    Vertex(String name) {
    	this.name = name;
    	neighbors = null;
    }

    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
    	return name;
    }
}
