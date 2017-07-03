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
		
		// Einlesen der Graphen Beispiele
		Graph<Vertex, Edge<Vertex>> graph8 = GraphLesen.FileToGraph("src/uebung3/GraphBeispiele/graph8.txt", true);
		Graph<Vertex, Edge<Vertex>> graph9 = GraphLesen.FileToGraph("src/uebung3/GraphBeispiele/graph9.txt", true);
		Graph<Vertex, Edge<Vertex>> graph20 = GraphLesen.FileToGraph("src/uebung3/GraphBeispiele/graph20.txt", true);


		Tiefensuche ts8 = new Tiefensuche(graph8);
		Tiefensuche ts9 = new Tiefensuche(graph9);
		Tiefensuche ts20 = new Tiefensuche(graph20);
		
		System.out.println("			    --Tiefensuche zu graph8.txt--");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(graph8);
		System.out.println("Nach der Tiefensuche: ");
		System.out.println("Pred:	" + Arrays.toString(ts8.pred));
		System.out.println("First:	" + Arrays.toString(ts8.first));
		System.out.println("Last:	" + Arrays.toString(ts8.last));
		System.out.println("");
		System.out.println(ts8.topological());
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("			    --Tiefensuche zu graph9.txt--");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(graph9);
		System.out.println("Nach der Tiefensuche: ");
		System.out.println("Pred:	" + Arrays.toString(ts9.pred));
		System.out.println("First:	" + Arrays.toString(ts9.first));
		System.out.println("Last:	" + Arrays.toString(ts9.last));
		System.out.println("");
		System.out.println(ts9.topological());
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("			    --Tiefensuche zu graph20.txt--");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(graph20);
		System.out.println("Nach der Tiefensuche: ");
		System.out.println("Pred:	" + Arrays.toString(ts20.pred));
		System.out.println("First:	" + Arrays.toString(ts20.first));
		System.out.println("Last:	" + Arrays.toString(ts20.last));
		System.out.println("");
		System.out.println(ts20.topological());
		System.out.println("---------------------------------------------------------------------------");
	}

}
