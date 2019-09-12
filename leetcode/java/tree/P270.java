package leetcode.java.tree;

import leetcode.java.util.TreeNode;

public class P270 {

	private double distance = Double.MAX_VALUE;
	private int ans = -1;

	public int closestValue(TreeNode root, double target) {
		search(root, target);
		return ans;
	}

	public void search(TreeNode node, double target) {
		double temp = Math.abs(node.val - target);
		if (temp < distance) {
			distance = temp;
			ans = node.val;
		}
		if (target < node.val && node.left != null) {
			search(node.left, target);
		}
		if (target > node.val && node.right != null) {
			search(node.right, target);
		}
	}

}
