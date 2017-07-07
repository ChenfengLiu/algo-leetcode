package leetcode_trees_graphs;

/**
 * Question 623: Add One Row to Tree -- Given the root of a binary tree, then
 * value v and depth d, you need to add a row of nodes with value v at the given
 * depth d. The root node is at depth 1.
 * 
 * The adding rule is: given a positive integer depth d, for each NOT null tree
 * nodes N in depth d-1, create two tree nodes with value v as N's left subtree
 * root and right subtree root. And N's original left subtree should be the left
 * subtree of the new left subtree root, its original right subtree should be
 * the right subtree of the new right subtree root. If depth d is 1 that means
 * there is no depth d-1 at all, then create a tree node with value v as the new
 * root of the whole original tree, and the original tree is the new root's left
 * subtree.
 * 
 * Note: 1. The given d is in range [1, maximum depth of the given tree + 1]. 2.
 * The given binary tree has at least one tree node.
 * 
 * @author chenfeng
 *
 */
public class AddOneRowToTree_623 {

	public static void main(String[] args) {
		// create test case
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);

		// compute result
		TreeNode result = addOneRow(root, 1, 2);
		printTree(result);

	}

	public static TreeNode addOneRow(TreeNode root, int v, int d) {
		if (d == 1) {
			TreeNode n = new TreeNode(v);
			n.left = root;
			return n;
		} else {
			preOrderTraversal(root, d, 1, v);
			return root;
		}

	}

	public static void preOrderTraversal(TreeNode n, int d, int currentDepth, int value) {
		if (n != null) {
			// add new node
			if (currentDepth == (d - 1)) {
				TreeNode newLeftNode = new TreeNode(value);
				TreeNode newRightNode = new TreeNode(value);
				if (n.left != null) {
					TreeNode temp = n.left;
					n.left = newLeftNode;
					newLeftNode.left = temp;
				} else {
					n.left = newLeftNode;
				}
				if (n.right != null) {
					TreeNode temp = n.right;
					n.right = newRightNode;
					newRightNode.right = temp;
				} else {
					n.right = newRightNode;
				}
				return;
			}

			preOrderTraversal(n.left, d, currentDepth + 1, value);
			preOrderTraversal(n.right, d, currentDepth + 1, value);
		}
	}

	public static void printTree(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + ", ");
			printTree(root.left);
			printTree(root.right);
		}
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
