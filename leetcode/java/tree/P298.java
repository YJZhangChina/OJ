package leetcode.java.tree;

import leetcode.java.util.TreeNode;

public class P298 {

	private int ans = 0;

	public int longestConsecutive(TreeNode root) {
		if (root != null) {
			search(root);
		}
		return ans;
	}

	public int search(TreeNode root) {
		if (root.left == null && root.right == null) {
			return 1;
		}
		int left = 0, right = 0;
		if (root.left != null) {
			left = search(root.left);
			left = root.val + 1 == root.left.val ? left : 0;
		}
		if (root.right != null) {
			right = search(root.right);
			right = root.val + 1 == root.right.val ? right : 0;
		}
		int sum = Math.max(left, right) + 1;
		System.out.println(root.val + " " + left + " " + right);
		ans = Math.max(ans, sum);
		return sum;
	}

}
