import java.io.IOException;
import java.util.ArrayList;

import structures.Arc;
import structures.Graph;
import structures.MinHeap;
import structures.Node;
import structures.Vertex;

public class MST_Kruskal {
	private ArrayList<Node<Vertex>> sets;
	
	/**
	 * initialization;making disjoint sets for every vertex of a given graph
	 *
	 * @param Graph graph, String file;
	 * @return ArrayList<Node<Vertex>> ret;
	 */
	
	public ArrayList<Node<Vertex>> initialzation(Graph graph, String file) throws IOException{
		if(graph == null){
			return null;
		}
		if(file == null){
			throw new IllegalArgumentException("no input file, abort!");
		}
		ArrayList<Node<Vertex>> ret = new ArrayList<Node<Vertex>>();
		
		for(int i = 0; i < graph.vertices.length; i++){
				Node<Vertex> node = new Node<Vertex>(graph.vertices[i],null,null);
				Node.makeSet(node);
				ret.add(node);
		}
		return ret;
	}
	
	/*
	 * sort the edges of the given graph into nondecreasing order.
	 */
	
	public MinHeap<Arc> sorting(Graph graph, String file) throws IOException{
		if(graph == null){
			return null;
		}
		if(file == null){
			throw new IllegalArgumentException("invalid input, halt!");
		}
		MinHeap<Arc> ret = new MinHeap<Arc>();
		for(int i =0; i < graph.vertices.length; i++){
			for(Vertex.Neighbor nbr = graph.vertices[i].neighbors; nbr != null; nbr = nbr.next){
				Arc arc = new Arc(graph.vertices[i],nbr.vertex,nbr.weight);
				ret.insert(arc);
				
				System.out.println("the added arc is " + arc);
				System.out.println("the vertex of current Neighbor is " + nbr.vertex);
				System.out.println();
			}
		}
		
		
		return ret;
	}
	
	
	/*
	 * execute and return the final result of MST.
	 */
	
	public ArrayList<Arc> execute(Graph graph, String file) throws IOException{
		if(graph == null){
			return null;
		}
		if(file == null){
			throw new IllegalArgumentException("HALT!!");
		}
		
		ArrayList<Arc> ret = new ArrayList<Arc>();
	
		MinHeap<Arc> mh = this.sorting(graph, file);
		ArrayList<Vertex> vertexList = null;
		
		this.sets = this.initialzation(graph, file);
		
		while(this.sets.size() >1){
			
			while(!mh.isEmpty()){
				Arc arc = mh.deleteMin();
				vertexList = Arc.getAdjacentVertices(arc);
				Vertex v1 = vertexList.get(0);
				Vertex v2 = vertexList.get(1);
				
				System.out.println("v1 is " + v1);
				System.out.println("v2 is " + v2);
				System.out.println();
			
				Node<Vertex> parent1 = this.findNode(v1);
				Node<Vertex> parent2 = this.findNode(v2);
				
				System.out.println("parent1 is " + parent1);
				System.out.println("parent2 is " + parent2);
				System.out.println();
			
			
				if(parent1 != null && parent2 !=null && !(parent1.getData().name.equals(parent2.getData().name))){
					ret.add(arc);
					
					Node<Vertex> unioned = parent1.union(parent1, parent2);	
					this.sets.add(unioned);
					this.sets.remove(parent2);
					this.sets.remove(parent1);
					
					break;
				}
			}
		}
		return ret;
		
	}
	
	

	/**
	 * find the Node<Vertex> in the ArrayList sets for
	 * a given Vertex v, and return the node of the parent of v
	 * 
	 * @param Vertex v
	 * @return Node<Vertex> parent;
	 */
	
	public Node<Vertex> findNode(Vertex v) throws IOException{
		if(v == null){
			throw new IllegalArgumentException("empty input, halt!");
		}
		Node<Vertex> ret = null;
		
		System.out.println("the size of sets is " + this.sets.size());
		System.out.println();
		
		for(int i = 0; i < this.sets.size(); i++){
			for(Node<Vertex> tmp = this.sets.get(i).getParent();tmp != null; tmp = tmp.flink){
				if(v.name.equals(tmp.getData().name)){
					ret = this.sets.get(i).getParent();
					break;
				}
			}
			
		}
		return ret;
	}
	
	/**
	 * return ArrayList<Node<Vertex>> sets
	 * 
	 * @return ArrayList<Node<Vertex>> sets
	 */
	
	public ArrayList<Node<Vertex>> getSet(){
		return this.sets;
	}
		
}
