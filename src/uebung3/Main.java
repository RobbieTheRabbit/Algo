package uebung3;

import java.util.Arrays;

import uebung3.graph.Edge;
import uebung3.graph.Graph;
import uebung3.graph.GraphLesen;
import uebung3.graph.Vertex;

/*********************************************************************
 * Die Main Klasse für die Tiefensuche
 * 
 * @author Sven Böhrnsen
 * @author Oliver Tili
 *********************************************************************/
public class Main {

	public static void main(String[] args) {
		Graph<Vertex, Edge<Vertex>> graph8 = GraphLesen.FileToGraph("src/uebung3/GraphBeispiele/graph8.txt", true);
		Graph<Vertex, Edge<Vertex>> graph9 = GraphLesen.FileToGraph("src/uebung3/GraphBeispiele/graph9.txt", true);
		Graph<Vertex, Edge<Vertex>> graph20 = GraphLesen.FileToGraph("src/uebung3/GraphBeispiele/graph20.txt", true);

		// System.out.println(graph8);


	}

}
