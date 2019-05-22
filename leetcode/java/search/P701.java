package leetcode.java.search;

import leetcode.java.util.TreeNode;

public class P701 {

	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		TreeNode node = root;
		search(root, val);
		return node;
	}

	public void search(TreeNode root, int target) {
		int value = root.val;
		if (value > target) {
			if (root.left == null) {
				root.left = new TreeNode(target);
			} else if (root.left.val < target) {
				if (getMaximum(root.left) < target) {
					TreeNode node = new TreeNode(target);
					node.left = root.left;
					root.left = node;
				} else {
					search(root.left, target);
				}
			} else {
				search(root.left, target);
			}
		} else if (value < target) {
			if (root.right == null) {
				root.right = new TreeNode(target);
			} else if (root.right.val > target) {
				if (getMinimum(root.right) > target) {
					TreeNode node = new TreeNode(target);
					node.right = root.right;
					root.right = node;
				} else {
					search(root.right, target);
				}
			} else {
				search(root.right, target);
			}
		}
	}

	public int getMinimum(TreeNode root) {
		return root.left == null ? root.val : getMinimum(root.left);
	}

	public int getMaximum(TreeNode root) {
		return root.right == null ? root.val : getMaximum(root.right);
	}

}
