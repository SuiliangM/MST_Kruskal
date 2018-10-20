/**
* Node<T> containing two pointers,
* flink, pointer to the next Node;
* parent, pointer to the "parent" node.
*/
	public class Node<T>{
		private T data;
		public Node<T> flink;
		private Node<T> parent;
		public Node(T data, Node<T> flink, Node<T> parent) {
			this.data = data;
			this.flink = flink;
			this.parent = parent;
		}
		
		
		/*
		 * create a disjoint set for a given node.
		 */
		
		public static<T> Node<T> makeSet(Node<T> node){
				node.flink = null;
				node.parent = node;
				return node;
			}
			
		
		/*
		 * Union(x,y) unites the dynamic sets that contain x and y, say Sx and Sy , into a
	     * new set that is the union of these two sets.Use the parent of Sx to represent
	     * the new united set. Return the parent of the new united set.
		 */
		
		public Node<T> union(Node<T> node1, Node<T> node2){
			if(node1 == null ){
				return null;
			}
			if(node2 == null){
				return node1.parent;
			}
			Node<T> parent = node1.parent;
			Node<T> currentParent = node2.parent;
			Node<T> tmp = null;
			for(tmp = parent;tmp.flink != null;tmp = tmp.flink){
				
			}
			tmp.flink = currentParent;
			
			for(tmp = currentParent;tmp != null;tmp = tmp.flink){
				tmp.parent = parent;
			}
			return parent;
		}
		
		/*
		 * findSet(x) returns a pointer of the representative of the set containing x
		 */
		
		public static<T> Node<T> findSet(Node<T> node){
			return node.parent;
		}
		
		/*
		 * return the data for a given Node
		 */
		
		public T getData(){
			return this.data;
		}
		
		/*
		 * return the parent of a this Node
		 */
		
		public Node<T> getParent(){
			return this.parent;
		}
		
		
		/*
		 * (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		
		public String toString() {
			return "" + data;
		}
		
	}
