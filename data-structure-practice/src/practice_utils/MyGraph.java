package practice_utils;

public class MyGraph {

	public static class GraphNode {
		public String name;
		public GraphNode[] children;
		public boolean visited = false;
		public State state;

		public enum State {
			Unvisited, Visited, Visiting;
		}
	}
	
	

	public GraphNode[] nodes;
}
