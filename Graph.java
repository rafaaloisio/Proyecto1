package Proyecto1;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Graph {
	
	private Map<Integer,Integer> nodes;
	private Map<String,Edge> edges;
	
	private static Logger logger;
	
	/**
	 * Constructor de la clase Graph. Instancia los nodos, los arcos y el logger.
	 */
	public Graph() {
		this.nodes = new HashMap<Integer,Integer>();
		this.edges = new HashMap<String,Edge>();
		
		if (logger == null){
			
			logger = Logger.getLogger(Graph.class.getName());
			
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);
			
			logger.setLevel(Level.WARNING);
			
			Logger rootLogger = logger.getParent();
			for (Handler h : rootLogger.getHandlers()){
				h.setLevel(Level.OFF);
			}
		}
	}
	
	/**
	 * Agrega un arco entre node1 y node2
	 * @param node1
	 * @param node2
	 */
	public void addEdge(int node1,int node2) {
		//cheque si los nodos est�n en el grafo
		boolean estaN1 = this.nodes.containsKey(node1);
		boolean estaN2 = this.nodes.containsKey(node2);
		
		//considerar los casos en que est�n o no los nodos
		
		if(estaN1 & estaN2) {
		
			Edge edge = new Edge(node1,node2);
			String key = node1+","+node2;
			Edge value = this.edges.put(key,edge);
			
			if(value!=null) {
					//significa que el arco ya estaba
					//System.out.println("Ya estaba el arco "+key);
					logger.warning("Ya existe el arco "+key);
					
			}else {
			
				//significa que el arco no estaba
				//aviso que se agreg� exitosamente
				//System.out.println("Se agreg� el arco "+key);
				logger.info("Se agreg� el arco "+key);
			}
		
		}else if(!estaN1) {
			//System.out.println("No est� nodo "+node1);
			logger.warning("No se encontr� el nodo "+node1+" al querer agregar el arco.");
	
		}else {
			//System.out.println("No est� nodo "+node2);
			logger.warning("No se encontr� el nodo "+node2+" al querer agregar el arco.");
		}
	}
	
	/**
	 * Elimina el arco entre el node1 y node2.
	 * @param node1
	 * @param node2
	 */
	public void removeEdge(int node1,int node2) {
		
		//cheque si los nodos est�n en el grafo
		boolean estaN1 = this.nodes.containsKey(node1);
		boolean estaN2 = this.nodes.containsKey(node2);
				
		//considerar los casos en que est�n o no los nodos
		
		String key = node1+","+node2;
		
		if(estaN1 & estaN2) {
			Edge r = edges.remove(key);
	
			if(r!=null) {
			//retorna true si se removi�
			//System.out.println("se removi� el arco "+key);
			logger.info("Se removi� exitosamente el arco "+key);
			
			}else {			
				//aviso que no se pudo remover
				//System.out.println("Se agreg� el arco "+key);
				logger.warning("No se pudo remover el arco "+key);
				}
			
			}else if(!estaN1) {
					//System.out.println("No est� nodo "+node1);
					logger.warning("No se encontr� el nodo "+node1+" al querer remover el arco "+key+".");
				}else {
					//System.out.println("No est� nodo "+node2);
					logger.warning("No se encontr� el nodo "+node2+" al querer remover el arco "+key+".");
				}	
		

	}
	
	/**
	 * Agrega el nodo node al grafo.
	 * @param node
	 */
	public void addNode(int node) {
		//chequeo si el nodo ya est� en el grafo
		boolean estaN = this.nodes.containsKey(node);
		
		if(!estaN) {
			//si no est�, lo agrego
			nodes.put(node,node);
			//aviso que se agreg� exitosamente
			//System.out.println("Se agreg� nodo "+node);
			logger.info("Se agreg� nodo "+node);
		}else {
			//si est�, warning que ya est�
			//System.out.println("ya estaba nodo "+node);
			logger.warning("Ya existe el nodo "+node);
		}
		
	}
	
	
	/**
	 * Elimina el nodo node del grafo.
	 * @param node
	 */
	public void removeNode(int node) {
		boolean estaN = this.nodes.containsKey(node);
		LinkedList<String> l = new LinkedList<String>();
		
		if(!estaN) {
			//si no est�
			//System.out.println("no se encontr� nodo "+node);
			logger.warning("No se encontr� nodo "+node+" al querer eliminarlo.");
			
		}else {
			
			//elimino todos los arcos que contengan al nodo
			
			for (String key : edges.keySet()) {
				 
				  if(key.indexOf(node+"")> -1) {
					  //System.out.println(key);
					  l.add(key);
				   }
			}
			
			while(!l.isEmpty()) {
				edges.remove(l.getFirst());
				l.remove();
			}
			
			//remuevo el nodo
			nodes.remove(node);
			
			//aviso que se elimin� exitosamente
			logger.info("Se elimin� nodo "+node+".");
			
			/*
			//listo los nodos y los arcos para ver que funcione
			for (Entry<Integer, Integer> entry : nodes.entrySet()) {
			    System.out.println("clave=" + entry.getKey() + " valor=" + entry.getValue());
			}
			
			for (Entry<String, Edge> entry : edges.entrySet()) {
			    System.out.println("clave=" + entry.getKey() + " valor=" + entry.getValue());
			}
			*/
			
		}
		
	}
	


}
