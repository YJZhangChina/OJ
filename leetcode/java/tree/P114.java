package leetcode.java.tree;

import java.util.Stack;

import leetcode.java.util.TreeNode;

public class P114 {

	private TreeNode previous = null;

	public void flatten(TreeNode node) {
		if (node == null) {
			return;
		}
		flatten(node.right);
		flatten(node.left);
		node.right = previous;
		node.left = null;
		previous = node;
	}

}
