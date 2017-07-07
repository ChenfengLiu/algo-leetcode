package cci_trees_graphs;

import practice_utils.MyTree.TreeNode;

/**
 * 
 * Validate BST: Implement a function to check if a binary tree is a binary
 * search tree.
 * 
 * @author chenfeng
 *
 */
public class ValidateBST_4_5 {

	public static void main(String[] args) {
		//

	}
	/////////////////////////////////////////////////////////////////////////////////
	// soln 1: left <= current < right
	/////////////////////////////////////////////////////////////////////////////////

	// Assume no duplicate values
	public static void copyBST(TreeNode root, int[] array, int index) {
		if (root == null)
			return;
		copyBST(root.left, array, index);
		array[index] = root.data;
		index++;
		copyBST(root.right, array, index);
	}

	public static boolean checkBST(TreeNode root) {
		int[] array = new int[root.subtreeSize];
		copyBST(root, array, 0);
		for (int i = 1; i < array.length; i++) {
			if (array[i] <= array[i - 1])
				return false;
		}
		return true;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// soln 2:
	/////////////////////////////////////////////////////////////////////////////////
	private static WrapInt last_printed = null;

	public static boolean checkBST2(TreeNode n) {
		if (n == null)
			return true;

		// Check / recurse left
		if (!checkBST2(n.left))
			return false;

		// Check current
		if (last_printed != null && n.data <= last_printed.value)
			return false;
		last_printed.value = n.data;

		// Check / recurse right
		if (!checkBST2(n.right))
			return false;

		return true;
	}

	public static class WrapInt {
		public int value;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// soln 3:
	/////////////////////////////////////////////////////////////////////////////////
	public static boolean checkBST3(TreeNode n) {

		return checkBST3(n, null, null);
	}

	public static boolean checkBST3(TreeNode n, Integer min, Integer max) {
		if (n == null) {
			return true;

		}
		if ((min != null && n.data <= min) || (max != null && n.data > max)) {
			return false;

		}
		if (!checkBST3(n.left, min, n.data) || !checkBST3(n.right, n.data, max)) {
			return false;
		}
		return true;

	}
}
