package cci_trees_graphs;

/**
 * Minimal Tree: Given a sorted (increasing order) array with unique integer
 * elements, write an algorithm to create a binary search tree with minimal
 * height.
 * 
 * @author chenfeng
 *
 */
public class MinimalTree_4_2 {

	public static void main(String[] args) {
		// create test case
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		TreeNode<Integer> result = createMinimalBST(arr);
		printLevelOrder(result);

	}

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

	public static void printLevelOrder(TreeNode root) {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++){
			printGivenLevel(root, i);
			System.out.println();
		}
			
	}

	public static int height(TreeNode root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	/* Print nodes at the given level */
	public static void printGivenLevel(TreeNode root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
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
