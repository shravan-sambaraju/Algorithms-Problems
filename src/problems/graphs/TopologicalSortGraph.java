package problems.graphs;

/** Sort the given graph topologically */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

class TopologicalSortGraph {
  private int V;
  private LinkedList<Integer> adj[];

  TopologicalSortGraph(int v) {
    V = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i) {
      adj[i] = new LinkedList();
    }
  }

  public static void main(String args[]) {
    TopologicalSortGraph g = new TopologicalSortGraph(6);
    g.addEdge(5, 2);
    g.addEdge(5, 0);
    g.addEdge(4, 0);
    g.addEdge(4, 1);
    g.addEdge(2, 3);
    g.addEdge(3, 1);

    System.out.println("Following is a Topological " + "sort of the given graph");
    g.topologicalSort();
  }

  private void addEdge(int v, int w) {
    adj[v].add(w);
  }

  private void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
    visited[v] = true;
    Integer i;
    Iterator<Integer> it = adj[v].iterator();
    while (it.hasNext()) {
      i = it.next();
      if (!visited[i]) {
        topologicalSortUtil(i, visited, stack);
      }
    }
    stack.push(new Integer(v));
  }

  private void topologicalSort() {
    Stack<Integer> stack = new Stack<Integer>();

    boolean visited[] = new boolean[V];
    for (int i = 0; i < V; i++) {
      visited[i] = false;
    }
    for (int i = 0; i < V; i++) {
      if (visited[i] == false) {
        topologicalSortUtil(i, visited, stack);
      }
    }
    while (stack.empty() == false) {
      System.out.print(stack.pop() + " ");
    }
  }
}
