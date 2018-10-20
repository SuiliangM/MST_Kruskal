package apps;

import java.io.IOException;
import java.util.ArrayList;

import structures.Arc;
import structures.Graph;
import structures.MinHeap;
import structures.Node;
import structures.Vertex;

public class MST_Driver {

	public static void main(String[] args) throws IOException {
		MST_Kruskal mst = new MST_Kruskal();
		
		Graph g = new Graph("graph1.txt");
		
		g.print();
		
		System.out.println();
		
		ArrayList<Node<Vertex>> arrList = mst.initialzation(g, "graph1.txt");
		
		for(int i = 0; i < arrList.size(); i++){
			System.out.println(arrList.get(i));
		}
		
		System.out.println("***************");
		
		
		ArrayList<Arc> result = mst.execute(g, "graph1.txt");
		
		for(int i = 0; i < result.size(); i++){
			System.out.println(result.get(i));
		}

	}

}
