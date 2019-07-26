package leetcode.java.tree;

import leetcode.java.util.TreeNode;

public class P538 {

	private int sum;

	public TreeNode convertBST(TreeNode root) {
		if (root != null) {
			sum = 0;
			search(root);
		}
		return root;
	}

	public void search(TreeNode node) {
		int value = node.val;
		if (node.right != null) {
			search(node.right);
		}
		node.val += sum;
		sum += value;
		if (node.left != null) {
			search(node.left);
		}
	}

}
