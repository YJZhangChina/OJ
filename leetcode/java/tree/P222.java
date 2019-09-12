package leetcode.java.tree;

import leetcode.java.util.TreeNode;

public class P222 {

	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		return countNodes(root.left) + countNodes(root.right) + 1;
	}

}
