package leetcode.java.tree;

import leetcode.java.util.TreeNode;

public class P671 {

	private int first = 0, second = 0;
	private boolean foundFirst = false, foundSecond = false;

	public int findSecondMinimumValue(TreeNode root) {
		dfs(root);
		return foundSecond ? second : -1;
	}

	public void dfs(TreeNode root) {
		if (root == null) {
			return;
		}
		int val = root.val;
		if (!foundFirst) {
			first = val;
			foundFirst = true;
		} else if (val < first) {
			second = first;
			first = val;
		} else if (val > first) {
			if (!foundSecond) {
				second = val;
				foundSecond = true;
			} else {
				second = Math.min(second, val);
			}
		}
		dfs(root.left);
		dfs(root.right);
	}

}
