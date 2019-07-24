package leetcode.java.tree;

import leetcode.java.util.TreeNode;

public class P285 {

	private TreeNode successor = null;
	private boolean found = false;

	public TreeNode inorderSuccessor(TreeNode root, TreeNode target) {
		if (root == null || target == null) {
			return null;
		}
		search(root, target);
		return successor;
	}

	public void search(TreeNode root, TreeNode target) {
		if (found && successor != null) {
			return;
		}
		if (root == null) {
			return;
		}
		search(root.left, target);
		if (root == target) {
			found = true;
		} else if (found && successor == null) {
			successor = root;
		}
		search(root.right, target);
	}

}
