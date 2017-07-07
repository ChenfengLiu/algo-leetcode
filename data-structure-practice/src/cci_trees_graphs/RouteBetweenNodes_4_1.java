package cci_trees_graphs;

import practice_utils.MyGraph.GraphNode;

import java.util.LinkedList;

import practice_utils.MyGraph;
import practice_utils.MyQueue;

/**
 * Route Between Nodes: Given a directed graph, design an algorithm to find out
 * whether there is a route between two nodes.
 * 
 * @author chenfeng
 *
 */
public class RouteBetweenNodes_4_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean search(MyGraph g, GraphNode start, GraphNode end) {
		if (start == end)
			return true;

		LinkedList<GraphNode> q = new LinkedList<GraphNode>();

		for (GraphNode n : g.nodes) {
			n.state = GraphNode.State.Unvisited;
		}

		start.state = GraphNode.State.Visiting;
		q.add(start);

		GraphNode u;
		while (!q.isEmpty()) {
			u = q.removeFirst();
			if (u != null) {
				for (GraphNode v : u.children) {
					if (v == end)
						return true;
					else {
						v.state = GraphNode.State.Visiting;
						q.add(v);
					} // End inner if-else
				} // End for loop
			} // End outer if
			u.state = GraphNode.State.Visited;
		} // End while loop
		return false;
	}

	public static void DFSearch(GraphNode root) {
		if (root == null)
			return;
		// visit(root);
		root.visited = true;
		for (GraphNode n : root.children) {
			if (!n.visited) {
				DFSearch(n);
			}
		}
	}

	public static void BFSearch(GraphNode root) {
		MyQueue<GraphNode> q = new MyQueue<GraphNode>();
		root.visited = true;
		q.add(root);

		while (!q.isEmpty()) {
			GraphNode r = q.remove();
			// visit(r);
			for (GraphNode n : r.children) {
				if (!n.visited)
					n.visited = true;
				q.add(n);
			} // End for loop
		} // End while loop
	}

}
