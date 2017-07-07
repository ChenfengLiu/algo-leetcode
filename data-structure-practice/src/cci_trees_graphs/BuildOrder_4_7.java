package cci_trees_graphs;

import java.util.ArrayList;
import java.util.Stack;

import practice_utils.DirectGraph;
import practice_utils.DirectGraph.Project;

/**
 * Build Order: You are given a list of projects and a list of dependencies
 * (which is a list of pairs of projects, where the second project is dependent
 * on the first project). All of a project's dependencies must be built before
 * the project is. Find a build order that will allow the projects to be built.
 * If there is no valid build order, return an error.
 * 
 * EXAMPLE
 * 
 * Input:
 * 
 * projects: a, b, c, d, e, f
 * 
 * dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
 * 
 * Output: f, e, a, b, d, c
 * 
 * @author chenfeng
 *
 */
public class BuildOrder_4_7 {

	public static void main(String[] args) {
		// create test case

	}

	/////////////////////////////////////////////////////////////////////////////////
	// soln 1:
	/////////////////////////////////////////////////////////////////////////////////

	public static Project[] findBuildOrder(String[] projects, String[][] dependencies) {
		DirectGraph graph = buildGraph(projects, dependencies);
		return orderProjects(graph.getNodes());
	}

	public static DirectGraph buildGraph(String[] projects, String[][] dependencies) {
		DirectGraph graph = new DirectGraph();
		for (String project : projects) {
			graph.getOrCreateNode(project);
		}

		for (String[] dependency : dependencies) {
			String first = dependency[0];
			String second = dependency[1];
			graph.addEdge(first, second);
		}
		return graph;
	}

	public static Project[] orderProjects(ArrayList<Project> arrayList) {
		Project[] order = new Project[arrayList.size()];
		int endOfList = addNonDependent(order, arrayList, 0);

		int toBeProcessed = 0;
		while (toBeProcessed < order.length) {
			Project current = order[toBeProcessed];

			if (current == null)
				return null;
			ArrayList<Project> children = current.getChildren();
			for (Project child : children)
				child.decrementDependencies();

			endOfList = addNonDependent(order, children, endOfList);
			toBeProcessed++;
		}

		return order;
	}

	public static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
		for (Project project : projects) {
			if (project.getNumDependencies() == 0) {
				order[offset] = project;
				offset++;
			}
		}
		return offset;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// soln 2: DFS
	/////////////////////////////////////////////////////////////////////////////////
	public static Stack<Project> findBuildOrder2(String[] projects, String[][] dependencies) {
		DirectGraph graph = buildGraph(projects, dependencies);

		return orderProjects2(graph.getNodes());
	}

	public static Stack<Project> orderProjects2(ArrayList<Project> arrlist) {

		Stack<Project> stack = new Stack<Project>();
		for (Project project : arrlist) {
			if (project.getState() == DirectGraph.Project.State.BLANK) {
				if (!doDFS(project, stack)) {
					return null;
				}
			} // End if
		} // End for loop
		return stack;
	}

	public static boolean doDFS(Project project, Stack<Project> stack) {
		if (project.getState() == DirectGraph.Project.State.PARTIAL) {
			return false; // Cycle
		}

		if (project.getState() == DirectGraph.Project.State.BLANK) {
			project.setState(DirectGraph.Project.State.PARTIAL);
			ArrayList<Project> children = project.getChildren();
			for (Project child : children) {
				if (!doDFS(child, stack)) {
					return false;
				}
			} // End for loop

			project.setState(DirectGraph.Project.State.COMPLETE);
			stack.push(project);
		} // End if
		return true;
	}
}
