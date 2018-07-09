package problems.graphs;

/* Find Route between two nodes */

import java.util.LinkedList;

class RouteBetweenTwoNodes {

	private class Node {
		private Node adjacent[];
		private int adjacentCount;
		private String vertex;
		RouteBetweenTwoNodes.State state;

		private Node(String vertex, int adjacentLength) {
			this.vertex = vertex;
			adjacentCount = 0;
			adjacent = new Node[adjacentLength];
		}

		private void addAdjacent(Node x) {
			if (adjacentCount < adjacent.length) {
				this.adjacent[adjacentCount] = x;
				adjacentCount++;
			} else {
				System.out.print("No more adjacent can be added");
			}
		}

		private Node[] getAdjacent() {
			return adjacent;
		}

		private String getVertex() {
			return vertex;
		}
	}

	private class Graph {
		private static final int MAX_VERTICES = 6;
		private Node vertices[];
		private int count;

		public Graph() {
			vertices = new Node[MAX_VERTICES];
			count = 0;
		}

		private void addNode(Node x) {
			if (count < vertices.length) {
				vertices[count] = x;
				count++;
			} else {
				System.out.print("Graph full");
			}
		}

		private Node[] getNodes() {
			return vertices;
		}
	}

	public enum State {
		Unvisited, Visited, Visiting;
	}

	public static void main(String a[]) {
		Graph g = createNewGraph();
		Node[] n = g.getNodes();
		Node start = n[3];
		Node end = n[5];
		System.out.println(search(g, start, end));
	}

	private static Graph createNewGraph() {
		RouteBetweenTwoNodes route = new RouteBetweenTwoNodes();
		Graph g = route.new Graph();
		Node[] temp = new Node[6];

		temp[0] = route.new Node("a", 3);
		temp[1] = route.new Node("b", 0);
		temp[2] = route.new Node("c", 0);
		temp[3] = route.new Node("d", 1);
		temp[4] = route.new Node("e", 1);
		temp[5] = route.new Node("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}

	private static boolean search(Graph g, Node start, Node end) {
		LinkedList<Node> q = new LinkedList<Node>();
		for (Node u : g.getNodes()) {
			u.state = State.Unvisited;
		}
		start.state = State.Visiting;
		q.add(start);
		Node u;
		while (!q.isEmpty()) {
			u = q.removeFirst();
			if (u != null) {
				for (Node v : u.getAdjacent()) {
					if (v.state == State.Unvisited) {
						if (v == end) {
							return true;
						} else {
							v.state = State.Visiting;
							q.add(v);
						}
					}
				}
				u.state = State.Visited;
			}
		}
		return false;
	}
}
