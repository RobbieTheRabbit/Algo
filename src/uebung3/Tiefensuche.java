package uebung3;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

import uebung3.graph.Edge;
import uebung3.graph.Graph;
import uebung3.graph.GraphLesen;
import uebung3.graph.Vertex;

/*********************************************************************
 * Dritte praktische uebung von Algorithmen SS17 Graphen Durchlaufstrategien -
 * Tiefensuche + topologische Sortierbarkeit
 * 
 * @author Sven Böhrnsen
 * @author Oliver Tili
 *********************************************************************/
public class Tiefensuche {

	// Liste der besuchten Knoten
	private int[] col;

	// zuerst besuchter Knoten
	private static int[] first;

	// Liste der Vorgänger
	private static int[] pred;

	// zuletzt besuchter Knoten
	private static int[] last;

	private Stack<Integer> stack = new Stack<>();

	// Knoten nicht besucht
	private final int white = 0;

	// Knoten wurde besucht
	private final int grey = 1;

	// Knoten wurde abgearbeitet
	private final int black = 2;

	private int time = 0;
	private static int counter = 0;

	// Kreisabfrage
	private boolean circle = false;

	private Graph<Vertex, Edge<Vertex>> graph;

	/*********************************************************************
	 * Kunstruktor für die Tiefensuche
	 * 
	 * @param graph
	 * @param vertex
	 *********************************************************************/
	public Tiefensuche(Graph<Vertex, Edge<Vertex>> graph, Vertex startV) {
		this.graph = graph;
		col = new int[graph.getNumberVertices()];
		pred = new int[graph.getNumberVertices()];
		first = new int[graph.getNumberVertices()];
		last = new int[graph.getNumberVertices()];

		for (Vertex vInit : graph.getVertices()) { // Knoten weiss setzen
			col[vInit.getId()] = white;
			// pred[vInit.getId()] = (Integer) null;

		}

		for (int i = 0; i < graph.getNumberVertices(); i++) {

			if (col[graph.getVertex(i).getId()] == white) {
				dfsRun(graph.getVertex(i));
			}

		}
		// for (Vertex vert : graph.getNeighbours(startV)) { // starte die
		// // Tiefensuche
		// if (col[vert.getId()] == white) {
		// dfsRun(vert);
		// }
		// }
		topological();

	}

	/*********************************************************************
	 * Tiefensuche mit Startknoten
	 * 
	 * @param verStart
	 *********************************************************************/
	public void dfsRun(Vertex verStart) {
		int verID = verStart.getId();

		col[verID] = grey;
		first[verID] = ++time;

		for (Vertex vertN : graph.getNeighbours(verID)) {
			if (col[vertN.getId()] == white) {
				pred[vertN.getId()] = verID;
				 if (pred[verID] == grey) {
				 circle = true;
				 }
				dfsRun(vertN);
			}
		}
		col[verID] = black;
		last[verID] = ++time;

		stack.push(verID);

	}

	/*********************************************************************
	 * Topologische Sortierung vom Graphen
	 *********************************************************************/
	public void topological() {

		// System.out.println("Pred: "+ Arrays.toString(pred));
		// System.out.println("First: " + Arrays.toString(first));
		// System.out.println("Last: " + Arrays.toString(last));
		System.out.println("Topologische Reihenfolge: ");
		if (circle != true) {
			while (!stack.isEmpty()) {
				System.out.print(stack.pop() + " ");
			}
			System.out.println("\n");

		} else {
			System.out.println("Kreis vorhanden --> Nicht topologisch sortierbar!");
		}

	}

	// TODO: Auslagern? als UnitTest?
	public static void main(String[] args) {
		Graph<Vertex, Edge<Vertex>> graph8 = GraphLesen.FileToGraph("src/uebung3/GraphBeispiele/graph8.txt", true);
		Graph<Vertex, Edge<Vertex>> graph9 = GraphLesen.FileToGraph("src/uebung3/GraphBeispiele/graph9.txt", true);
		Graph<Vertex, Edge<Vertex>> graph20 = GraphLesen.FileToGraph("src/uebung3/GraphBeispiele/graph20.txt", true);

		// System.out.println(graph8);

		Tiefensuche ts8 = new Tiefensuche(graph8, graph8.getVertex(0));
		Tiefensuche ts9 = new Tiefensuche(graph9, graph9.getVertex(0));
		Tiefensuche ts20 = new Tiefensuche(graph20, graph20.getVertex(0));

	}

}
