package practice_utils;

import java.util.ArrayList;
import java.util.HashMap;

public class DirectGraph {

	public class DirectGraphNode {
		public String name;
		public DirectGraphNode[] parents, children;
		public boolean visited = false;
	}

	private ArrayList<Project> nodes = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<>();

	public Project getOrCreateNode(String name) {
		if (!map.containsKey(name)) {
			Project node = new Project(name);
			nodes.add(node);
			map.put(name, node);
		}
		return map.get(name);
	}

	public void addEdge(String startName, String endName) {
		Project start = getOrCreateNode(startName);
		Project end = getOrCreateNode(endName);
		start.addNeighbor(end);
	}

	public ArrayList<Project> getNodes() {
		return nodes;
	}

	public static class Project {
		private ArrayList<Project> children = new ArrayList<>();
		private HashMap<String, Project> map = new HashMap<>();
		private String name;
		private int dependencies = 0;

		public Project(String n) {
			name = n;
		}

		public void addNeighbor(Project node) {
			if (!map.containsKey(node.getName())) {
				children.add(node);
				map.put(node.getName(), node);
				node.dependencies++;
			}
		}

		public void incrementDependencies() {
			dependencies++;
		}

		public void decrementDependencies() {
			dependencies--;
		}

		public String getName() {
			return name;
		}

		public ArrayList<Project> getChildren() {
			return children;
		}

		public int getNumDependencies() {
			return dependencies;
		}

		// added
		private State state = State.BLANK;

		public State getState() {
			return state;
		}

		public void setState(State st) {
			state = st;
		}
		public enum State {
			COMPLETE, PARTIAL, BLANK
		};
	}
}
