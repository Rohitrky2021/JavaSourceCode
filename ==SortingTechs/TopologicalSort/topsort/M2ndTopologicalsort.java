// Java program for above approach
import java.util.*;

class Graph{
	private Map<Integer, List<Integer>> graph; // adjacency list
	private int V; // number of vertices

	public Graph(int vertices) {
		V = vertices;
		graph = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < V; i++) {
			graph.put(i, new ArrayList<Integer>());
		}
	}

	// function to add an edge to graph
	public void addEdge(int u, int v) {
		graph.get(u).add(v);
	}

	// non-recursive topological sort
	public void nonRecursiveTopologicalSort() {
		boolean[] visited = new boolean[V]; // mark all the vertices as not visited
		Stack<Integer> stack = new Stack<Integer>(); // result stack

		// call the helper function to store Topological
		// Sort starting from all vertices one by one
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				nonRecursiveTopologicalSortUtil(i, visited, stack);
			}
		}

		// print contents of the stack in reverse
		List<Integer> sorted = new ArrayList<Integer>();
		while (!stack.empty()) {
			sorted.add(stack.pop());
		}
		System.out.print("The following is a Topological Sort of the given graph:\n");
		for (int i : sorted) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	// helper function for non-recursive topological sort
	private void nonRecursiveTopologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
		visited[v] = true;

		for (int nextNeighbor : graph.get(v)) {
			if (!visited[nextNeighbor]) {
				nonRecursiveTopologicalSortUtil(nextNeighbor, visited, stack);
			}
		}
		stack.push(v);
	}
}

public class k2ndTopologicalsort {
	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		g.nonRecursiveTopologicalSort();
	}
}

// This code is contributed by Pushpesh Raj.
