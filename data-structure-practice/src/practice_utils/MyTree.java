package practice_utils;

public class MyTree {

	public class TreeNode {

		// general tree variables
		public String name;
		public TreeNode parent;
		public TreeNode[] children;
		public boolean visited = false;
		public int data;

		// Binary tree variables
		public TreeNode left, right;
		public int subtreeSize = 1;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	public TreeNode root;

	public void insert(TreeNode n) {
		if (root == null) {
			root = n;
			return;
		}

		TreeNode parent = root;
		TreeNode current = root;
		while (current != null) {
			parent = current;
			++current.subtreeSize;
			if (n.data <= current.data)
				current = current.left;
			else
				current = current.right;

		} // End while loop

		if (n.data <= parent.data)
			parent.left = n;
		else
			parent.right = n;

		n.parent = parent;

	}

}