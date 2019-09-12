package leetcode.java.tree;

import leetcode.java.util.TreeNode;

public class P236 {

	private TreeNode ancestor;
	private int length;

	// needs to improve
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		ancestor = null;
		length = Integer.MAX_VALUE;
		search(root, p, q);
		return ancestor;
	}

	public int search(TreeNode node, TreeNode p, TreeNode q) {
		if (node == null) {
			return -1;
		}
		int left = search(node.left, p, q), right = search(node.right, p, q);
		if (left == -1 && right == -1) {
			if (node == p || node == q) {
				return 1;
			} else {
				return -1;
			}
		} else if (left == -1 && right != -1) {
			if (node == p || node == q) {
				if (right < length) {
					length = right;
					ancestor = node;
				}
				return right;
			} else {
				return right + 1;
			}
		} else if (left != -1 && right == -1) {
			if (node == p || node == q) {
				if (left < length) {
					length = left;
					ancestor = node;
				}
				return left;
			} else {
				return left + 1;
			}
		} else {
			if (left + right < length) {
				length = left + right;
				ancestor = node;
			}
			return left + right;
		}
	}

}
