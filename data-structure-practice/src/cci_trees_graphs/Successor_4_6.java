package cci_trees_graphs;

import practice_utils.MyTree.TreeNode;

/**
 * Successor: Write an algorithm to find the "next" node (i.e., in-order
 * successor) of a given node in a binary search tree. You may assume that each
 * node has a link to its parent.
 * 
 * @author chenfeng
 *
 */
public class Successor_4_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/////////////////////////////////////////////////////////////////////////////////
	// soln 1:
	/////////////////////////////////////////////////////////////////////////////////
	public static TreeNode inorderSucc(TreeNode n) {
		if (n == null)
			return null;

		// found right children -> return leftmost node of the right subtree
		if (n.right != null)
			return leftMostChild(n.right);
		else {
			TreeNode q = n;
			TreeNode x = q.parent;
			// go up until on the left instead of right
			while (x != null && x.left != q) {
				q = x;
				x = x.parent;
			}
			return x;
		}
	}

	public static TreeNode leftMostChild(TreeNode n) {
		if (n == null)
			return null;
		while (n.left != null)
			n = n.left;
		return n;
	}

}
