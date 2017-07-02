package uebung3;

import java.util.Arrays;
import java.util.Stack;
import uebung3.graph.Edge;
import uebung3.graph.Graph;
import uebung3.graph.Vertex;

/*********************************************************************
 * Dritte praktische uebung von Algorithmen SS17 Graphen Durchlaufstrategien -
 * Tiefensuche + topologische Sortierbarkeit
 * 
 * @author Sven Böhrnsen
 * @author Oliver Tili
 *********************************************************************/
public class Tiefensuche {
	private int[] col;
	private static int[] first;
	private static int[] pred;
	private static int[] last;
	private final int white = 0;
	private final int grey = 1;
	private final int black = 2;
	private int time = 0;
	private boolean circle = false;
	private Graph<Vertex, Edge<Vertex>> graph;

	/*********************************************************************
	 * Kunstruktor für die Tiefensuche, dass eine 3 int Arrays mit
	 * einer beliebigen Groeße erstellt
	 * 
	 * @param graph
	 * @param vertex
	 *********************************************************************/
	public Tiefensuche(Graph<Vertex, Edge<Vertex>> graph) {
		this.graph = graph;
		col = new int[graph.getNumberVertices()];
		pred = new int[graph.getNumberVertices()];
		first = new int[graph.getNumberVertices()];
		last = new int[graph.getNumberVertices()];

		for (Vertex vInit : graph.getVertices()) { // Knoten weiss setzen
			col[vInit.getId()] = white;

		}

		for (int i = 0; i < graph.getNumberVertices(); i++) {

			if (col[graph.getVertex(i).getId()] == white) {
				dfsVisit(graph.getVertex(i));
			}

		}
		// for (Vertex vert : graph.getNeighbours(startV)) { // starte die
		// // Tiefensuche
		// if (col[vert.getId()] == white) {
		// dfsRun(vert);
		// }
		// }

		output();
		topological();

	}

	/*********************************************************************
	 * Tiefensuche mit Startknoten
	 * 
	 * @param verStart
	 *********************************************************************/
	public void dfsVisit(Vertex verStart) {
		int verID = verStart.getId();

		col[verID] = grey;
		first[verID] = ++time;

		for (Vertex verNab : graph.getNeighbours(verID)) {
			if (col[verNab.getId()] == white) {
				pred[verNab.getId()] = verID;
				// TODO Kreisabfrage
				// if (pred[verID] == grey) {
				// circle = true;
				// }
				dfsVisit(verNab);
			}
		}
		col[verID] = black;
		last[verID] = ++time;


	}

	/*********************************************************************
	 * Topologische Sortierung vom Graphen
	 *********************************************************************/
	public void topological() {

		System.out.println("Topologische Sortierung: ");
		if (circle != true) {
			}
			System.out.print("\n");
			System.out.println("---------------------------------------------------------------------------");

		} else {
			System.out.println("Kreis im Graphen vorhanden --> Nicht topologisch sortierbar!");
			System.out.println("---------------------------------------------------------------------------");
		}

	}

	/*********************************************************************
	 * Methode um die Tiefensuche zu testen
	 *********************************************************************/
	private void output() {
		System.out.println("			    --Tiefensuche--");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(graph);
		System.out.println("Nach der Tiefensuche: ");
		System.out.println("Pred:	" + Arrays.toString(pred));
		System.out.println("First:	" + Arrays.toString(first));
		System.out.println("Last:	" + Arrays.toString(last));
		System.out.println("");

	}

}
