package uebung3;

import java.util.ArrayList;
import java.util.Stack;
import uebung3.graph.Edge;
import uebung3.graph.Graph;
import uebung3.graph.Vertex;

/*********************************************************************
 * Dritte praktische uebung von Algorithmen SS17 Graphen Durchlaufstrategien -
 * Tiefensuche + topologische Sortierung
 * 
 * @author Sven Böhrnsen
 * @author Oliver Tili
 *********************************************************************/
public class Tiefensuche {
	private int[] col;
	static int[] first;
	static int[] pred;
	static int[] last;
	private final int white = 0;
	private final int grey = 1;
	private final int black = 2;
	private int time = 0;
	private Graph<Vertex, Edge<Vertex>> graph;
	private Stack<Integer> topoStack = new Stack<>();

	/*********************************************************************
	 * Kunstruktor für die Tiefensuche, dass 4 int Arrays mit einer beliebigen
	 * Groeße erstellt
	 * 
	 * @param graph Eingelesene Adjazenzliste
	 *********************************************************************/
	public Tiefensuche(Graph<Vertex, Edge<Vertex>> graph) {
		this.graph = graph;
		col = new int[graph.getNumberVertices()];
		pred = new int[graph.getNumberVertices()];
		first = new int[graph.getNumberVertices()];
		last = new int[graph.getNumberVertices()];

		for (Vertex vInit : graph.getVertices()) { // übergebende Knoten auf
													// weiss setzen
			col[vInit.getId()] = white;

		}

		for (int i = 0; i < graph.getNumberVertices(); i++) {

			if (col[graph.getVertex(i).getId()] == white) { // DFS auf weisse
															// Knoten anweden
				dfsVisit(graph.getVertex(i));
			}
		}
	}

	/*********************************************************************
	 * Funktion für die Tiefensuche mit übergebenden Startknoten
	 * 
	 * @param verStart Knoten, bei dem die Tiefensuche starten soll
	 *********************************************************************/
	public void dfsVisit(Vertex verStart) {
		int verID = verStart.getId();

		col[verID] = grey;
		first[verID] = ++time;

		for (Vertex verNab : graph.getNeighbours(verID)) { // Für alle Nachbarn
															// vom Knoten
			if (col[verNab.getId()] == white) {
				pred[verNab.getId()] = verID;

				dfsVisit(verNab);
			}
		}
		col[verID] = black;
		last[verID] = ++time;
		topoStack.push(verID); // Fügt den Knoten in einen Stack sobald ein
								// Lastwert hat
	}

	/*********************************************************************
	 * Funktion für die Topologische Sortierung vom Graphen nach der Tiefensuche
	 *********************************************************************/
	public ArrayList topological() {
		ArrayList topoList = new ArrayList<>();

		System.out.println("Topologische Sortierung: ");
		while (!topoStack.isEmpty()) {
			topoList.add(topoStack.pop());
		}
		return topoList;
	}

}
