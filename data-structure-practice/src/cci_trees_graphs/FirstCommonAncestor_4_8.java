package cci_trees_graphs;

import practice_utils.MyTree.TreeNode;

/**
 * First Common Ancestor: Design an algorithm and write code to find the first
 * common ancestor of two nodes in a binary tree. Avoid storing additional nodes
 * in a data structure. NOTE: This is not necessarily a binary search tree.
 * 
 * @author chenfeng
 *
 */
public class FirstCommonAncestor_4_8 {

	public static void main(String[] args) {
		// create test case

	}

	/////////////////////////////////////////////////////////////////////////////////
	// soln 1: With Links to Parents
	/////////////////////////////////////////////////////////////////////////////////
	public static TreeNode commonAncestor(TreeNode p, TreeNode q) {

		int delta = depth(p) - depth(q); // get difference in depths
		TreeNode first = delta > 0 ? q : p; // get shallower node
		TreeNode second = delta > 0 ? p : q; // get deeper node
		second = goUpBy(second, Math.abs(delta)); // move deeper node up

		/* Find where paths intersect. */
		while (first != second && first != null && second != null) {
			first = first.parent;
			second = second.parent;
		}
		return first == null || second == null ? null : first;
	}

	public static TreeNode goUpBy(TreeNode node, int delta) {
		while (delta > 0 && node != null) {
			node = node.parent;
			delta--;
		}
		return node;
	}

	public static int depth(TreeNode node) {
		int depth = 0;
		while (node != null) {
			node = node.parent;
			depth++;
		}
		return depth;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// soln 2: With Links to Parents
	/////////////////////////////////////////////////////////////////////////////////
	public static TreeNode commonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		/*
		 * Check if either node is not in the tree, or if one covers the other.
		 */
		if (!covers(root, p) || !covers(root, q)) {
			return null;
		} else if (covers(p, q)) {
			return p;
		} else if (covers(q, p)) {
			return q;
		}

		/* Traverse upwards until you find a node that covers q. */
		TreeNode sibling = getSibling(p);
		TreeNode parent = p.parent;
		while (!covers(sibling, q)) {
			sibling = getSibling(parent);
			parent = parent.parent;
		}
		return parent;
	}

	public static boolean covers(TreeNode root, TreeNode p) {
		if (root == null)
			return false;
		if (root == p)
			return true;
		return covers(root.left, p) || covers(root.right, p);
	}

	public static TreeNode getSibling(TreeNode node) {
		if (node == null || node.parent == null) {
			return null;
		}
		TreeNode parent = node.parent;
		return parent.left == node ? parent.right : parent.left;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// soln 3: Without Links to Parents
	/////////////////////////////////////////////////////////////////////////////////
	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		/* Error check - one node is not in the tree. */
		if (!covers(root, p) || !covers(root, q)) {
			return null;
		}
		return ancestorHelper(root, p, q);
	}

	public static TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}

		boolean pIsOnLeft = covers(root.left, p);
		boolean qIsOnLeft = covers(root.left, q);
		if (pIsOnLeft != qIsOnLeft) {// Nodes are on different side
			return root;
		}

		TreeNode childSide = pIsOnLeft ? root.left : root.right;

		return ancestorHelper(childSide, p, q);
	}
}
