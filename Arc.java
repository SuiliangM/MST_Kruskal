import java.util.ArrayList;

public class Arc implements Comparable<Arc> {
	/**
     * A vertex at one end of this arc.
     */
    Vertex v1;

    /**
     * A vertex at one end of this arc.
     */
    Vertex v2;

    /**
     * Weight assigned to this arc.
     */
    int weight;

    /**
     * Constructs a new Arc object from an existing edge in a graph.
     * 
     * @param v1 Vertex at one end of the edge.
     * @param v2 Vertex at the other end of the edge.
     * @param weight Weight of the edge.
     */
    public Arc(Vertex v1, Vertex v2, int weight) {
    	this.v1 = v1;
    	this.v2 = v2;
    	this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
    	if (o == null || !(o instanceof Arc)) {
    		return false;
    	}
    	Arc other = (Arc)o;
    	return weight == other.weight && 
    			((v1.name.equals(other.v1.name) && v2.name.equals(other.v2.name)) ||
    			 (v1.name.equals(other.v2.name) && v2.name.equals(other.v1.name)));
    }
    
    /**
     * Compares the weight of this arc with that of another.
     * 
     * @param other Other arc
     * @return 0 if the weights are equal, +ve if this arc's weight is greater, -ve otherwise
     * 
     */
    public int compareTo(Arc other) {
    	return weight - other.weight;
    }
    
    /**
     * return the adjacent vertices of an given arc.
     * @param Arc arc
     * @return ArrayList<Vertex>
     */
    
    public static ArrayList<Vertex> getAdjacentVertices(Arc arc){
    	if(arc == null){
    		return null;
    	}
    	ArrayList<Vertex> ret = new ArrayList<Vertex>();
    	
    	ret.add(arc.v1);
    	ret.add(arc.v2);
    	
    	return ret;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
    	return "(" + v1 + " " + v2 + " " + weight + ")";
    }

}
