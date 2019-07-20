package leetcode.java.tree;

import leetcode.java.util.TreeNode;

public class P897 {

    private TreeNode start = null, end = null;

	public TreeNode increasingBST(TreeNode root) {
		search(root);
		return start;
	}

	public void search(TreeNode node) {
		if (node != null) {
			search(node.left);
			if (end != null) {
				end.right = node;
                node.left = null;
			} else {
				start = node;
			}
			end = node;
			search(node.right);
		}
	}

}