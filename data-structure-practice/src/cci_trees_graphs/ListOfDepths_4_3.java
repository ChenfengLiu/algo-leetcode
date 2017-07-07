package cci_trees_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import cci_trees_graphs.MinimalTree_4_2.TreeNode;

public class ListOfDepths_4_3 {

	public static void main(String[] args) {
		// create test case
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		TreeNode<Integer> root = createMinimalBST(arr);

		// compute result
		ArrayList<LinkedList<TreeNode<Integer>>> lists = createLevelLinkedList(root);
		for (LinkedList<TreeNode<Integer>> ll : lists) {
			for (int i = 0; i < ll.size(); i++) {
				System.out.print(ll.get(i).data + " ");
			}
			System.out.println();
		}

	}

	public static ArrayList<LinkedList<TreeNode<Integer>>> createLevelLinkedList(TreeNode<Integer> root) {
		ArrayList<LinkedList<TreeNode<Integer>>> lists = new ArrayList<LinkedList<TreeNode<Integer>>>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}

	public static void createLevelLinkedList(TreeNode<Integer> root, ArrayList<LinkedList<TreeNode<Integer>>> lists,
			int level) {
		if (root == null)
			return;

		LinkedList<TreeNode<Integer>> list = null;
		if (lists.size() == level) {
			list = new LinkedList<TreeNode<Integer>>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedList(root.left, lists, level + 1);
		createLevelLinkedList(root.right, lists, level + 1);
	}

	// Test helper methods
	public static TreeNode<Integer> createMinimalBST(int[] arr) {
		return createMinimalBST(arr, 0, arr.length - 1);
	}

	public static TreeNode<Integer> createMinimalBST(int[] arr, int start, int end) {
		if (end < start)
			return null;

		int mid = (start + end) / 2;
		TreeNode<Integer> n = new TreeNode<Integer>(arr[mid]);
		n.left = createMinimalBST(arr, start, mid - 1);
		n.right = createMinimalBST(arr, mid + 1, end);
		return n;
	}

	public static class TreeNode<T> {
		public String name;
		public TreeNode left, right;
		public boolean visited = false;
		public T data;

		public TreeNode(T data) {
			this.data = data;
		}
	}

}
