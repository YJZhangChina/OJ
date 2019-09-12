package leetcode.java.tree;

import java.util.HashSet;
import java.util.Set;

import leetcode.java.util.TreeNode;

public class P653 {

	private Set<Integer> set = new HashSet<>();
	private boolean result = false;

	public boolean findTarget(TreeNode root, int target) {
		set.clear();
		if (root != null) {
			inorder(root, target);
		}
		return result;
	}

	public void inorder(TreeNode node, int target) {
		if (result) {
			return;
		}
		if (node.left != null) {
			inorder(node.left, target);
		}
		int value = node.val;
		if (set.contains(target - value)) {
			result = true;
		} else {
			set.add(value);
		}
		if (node.right != null) {
			inorder(node.right, target);
		}
	}

}
