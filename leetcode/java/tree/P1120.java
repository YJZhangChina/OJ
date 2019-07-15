package leetcode.java.tree;

import leetcode.java.util.TreeNode;

public class P1120 {

	private double ans = 0.0;

	public double maximumAverageSubtree(TreeNode root) {
		transfer(root);
		return ans;
	}

	public int[] transfer(TreeNode node) {
		if (node == null) {
			return new int[] { 0, 0 };
		}
		int[] left = transfer(node.left), right = transfer(node.right);
		int sum = left[0] + right[0] + node.val, num = left[1] + right[1] + 1;
		ans = Math.max(ans, (double) sum / (double) num);
		return new int[] { sum, num };
	}

}
