
// A Java program for Bellman-Ford's single source shortest--->USED WHEN WEIGHT== IS -VE ;
// path algorithm.

import java.io.*;
import java.lang.*;
import java.util.*;

// A class to represent a connected, directed and weighted
// Bellmanford 
class Bellmanford {
	
	// A class to represent a weighted edge in Bellmanford 
	class Edge {
		int src, dest, weight;
		Edge() { src = dest = weight = 0; }
	};

	int V, E;
	Edge edge[];

	// Creates a Bellmanford with V vertices and E edges
	Bellmanford (int v, int e)
	{
		V = v;
		E = e;
		edge = new Edge[e];
		for (int i = 0; i < e; ++i)
			edge[i] = new Edge();
	}

	// The main function that finds shortest distances from
	// src to all other vertices using Bellman-Ford
	// algorithm. The function also detects negative weight
	// cycle
	void BellmanFord(Bellmanford Bellmanford , int src)
	{
		int V = Bellmanford .V, E = Bellmanford .E;
		int dist[] = new int[V];

		// Step 1: Initialize distances from src to all
		// other vertices as INFINITE
		for (int i = 0; i < V; ++i)
			dist[i] = Integer.MAX_VALUE;
		dist[src] = 0;

		// Step 2: Relax all edges |V| - 1 times. A simple
		// shortest path from src to any other vertex can
		// have at-most |V| - 1 edges
		for (int i = 1; i < V; ++i) {
			for (int j = 0; j < E; ++j) {
				int u = Bellmanford .edge[j].src;
				int v = Bellmanford .edge[j].dest;
				int weight = Bellmanford .edge[j].weight;
				if (dist[u] != Integer.MAX_VALUE
					&& dist[u] + weight < dist[v])
					dist[v] = dist[u] + weight;
			}
		}

		// Step 3: check for negative-weight cycles. The
		// above step guarantees shortest distances if Bellmanford 
		// doesn't contain negative weight cycle. If we get
		// a shorter path, then there is a cycle.
		for (int j = 0; j < E; ++j) {
			int u = Bellmanford .edge[j].src;
			int v = Bellmanford .edge[j].dest;
			int weight = Bellmanford .edge[j].weight;
			if (dist[u] != Integer.MAX_VALUE
				&& dist[u] + weight < dist[v]) {
				System.out.println(
					"Bellmanford contains negative weight cycle");
				return;
			}
		}
		printArr(dist, V);
	}

	// A utility function used to print the solution
	void printArr(int dist[], int V)
	{
		System.out.println("Vertex Distance from Source");
		for (int i = 0; i < V; ++i)
			System.out.println(i + "\t\t" + dist[i]);
	}

	// Driver's code
	public static void main(String[] args)
	{
		int V = 5; // Number of vertices in Bellmanford 
		int E = 8; // Number of edges in Bellmanford 

		Bellmanford Bellmanford = new Bellmanford (V, E);

		// add edge 0-1 (or A-B in above figure)
		Bellmanford .edge[0].src = 0;
		Bellmanford .edge[0].dest = 1;
		Bellmanford .edge[0].weight = -1;

		// add edge 0-2 (or A-C in above figure)
		Bellmanford .edge[1].src = 0;
		Bellmanford .edge[1].dest = 2;
		Bellmanford .edge[1].weight = 4;

		// add edge 1-2 (or B-C in above figure)
		Bellmanford .edge[2].src = 1;
		Bellmanford .edge[2].dest = 2;
		Bellmanford .edge[2].weight = 3;

		// add edge 1-3 (or B-D in above figure)
		Bellmanford .edge[3].src = 1;
		Bellmanford .edge[3].dest = 3;
		Bellmanford .edge[3].weight = 2;

		// add edge 1-4 (or B-E in above figure)
		Bellmanford .edge[4].src = 1;
		Bellmanford .edge[4].dest = 4;
		Bellmanford .edge[4].weight = 2;

		// add edge 3-2 (or D-C in above figure)
		Bellmanford .edge[5].src = 3;
		Bellmanford .edge[5].dest = 2;
		Bellmanford .edge[5].weight = 5;

		// add edge 3-1 (or D-B in above figure)
		Bellmanford .edge[6].src = 3;
		Bellmanford .edge[6].dest = 1;
		Bellmanford .edge[6].weight = 1;

		// add edge 4-3 (or E-D in above figure)
		Bellmanford .edge[7].src = 4;
		Bellmanford .edge[7].dest = 3;
		Bellmanford .edge[7].weight = -3;
		
		// Function call
		Bellmanford .BellmanFord(Bellmanford , 0);
	}
}
// Contributed by Aakash Hasija
