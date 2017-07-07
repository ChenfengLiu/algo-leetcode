package cci_trees_graphs;

import cci_trees_graphs.ListOfDepths_4_3.TreeNode;

/**
 * Check Balanced: Implement a function to check if a binary tree is balanced.
 * For the purposes of this question, a balanced tree is defined to be a tree
 * such that the heights of the two subtrees of any node never differ by more
 * than one.
 * 
 * @author chenfeng
 *
 */
public class CheckBalanced_4_4 {

	public static void main(String[] args) {
		// create test case
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		TreeNode<Integer> root = createMinimalBST(arr);

		// compute result
		if (isBalanced(root))
			System.out.println("The tree is balanced");
		else
			System.out.println("The tree is NOT balanced");
	}

	/////////////////////////////////////////////////////////////////////////////////
	// soln 1:
	/////////////////////////////////////////////////////////////////////////////////
	public static int getHeight(TreeNode<Integer> r) {
		if (r == null)
			return -1;
		return Math.max(getHeight(r.left), getHeight(r.right)) + 1;
	}

	public static boolean isBalanced(TreeNode<Integer> r) {
		if (r == null)
			return true;
		int heightDiff = getHeight(r.left) - getHeight(r.right);

		if (Math.abs(heightDiff) > 1)
			return false;
		else
			return isBalanced(r.left) && isBalanced(r.left);
	}

	/////////////////////////////////////////////////////////////////////////////////
	// soln 2:
	/////////////////////////////////////////////////////////////////////////////////
	public static int checkHeight(TreeNode<Integer> r) {
		if (r == null)
			return -1;
		int leftHeight = checkHeight(r.left);
		if (leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		int rightHeight = checkHeight(r.right);
		if (rightHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		int heightDiff = leftHeight - rightHeight;

		if (Math.abs(heightDiff) > 1)
			return Integer.MIN_VALUE; // Found error -> pass it back
		else
			return Math.max(leftHeight, rightHeight) + 1;
	}

	public static boolean isBalanced2(TreeNode<Integer> root) {

		return checkHeight(root) != Integer.MIN_VALUE;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// Test helper methods
	/////////////////////////////////////////////////////////////////////////////////
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
