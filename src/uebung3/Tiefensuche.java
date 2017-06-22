package uebung3;

import uebung3.graph.Edge;
import uebung3.graph.Graph;
import uebung3.graph.GraphLesen;
import uebung3.graph.Vertex;

/*********************************************************************
 * Dritte praktische uebung von Algorithmen SS17
 * 
 * @author Sven Böhrnsen
 * @author Oliver Tili 
 *********************************************************************/
public class Tiefensuche {

	public static void main(String[] args) {
		Graph<Vertex, Edge<Vertex>> graph = GraphLesen.FileToGraph("src/uebung3/GraphBeispiele/graph8.txt", true);
		
		System.out.println(graph);
	}

}
