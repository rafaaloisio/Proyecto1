package Proyecto1;

public class Proyecto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph grafo = new Graph();
		
		grafo.addNode(1);
		grafo.addNode(2);
		grafo.addNode(3);
		grafo.addNode(4);
		
		
		grafo.addEdge(1,2);
		grafo.addEdge(2,3);
		grafo.addEdge(2,4);
		grafo.addEdge(3,1);
	
		
		grafo.addEdge(5,1);
		
		grafo.addEdge(1,6);
		
		grafo.removeNode(1);
		
		grafo.removeEdge(2,3);
		
		grafo.removeEdge(1,2);
		
		grafo.removeNode(3);
		
		grafo.addEdge(4,3);
		
		
		
	}

}
