package leetcode.java.tree;

import leetcode.java.util.TreeNode;

public class P108 {

	public TreeNode sortedArrayToBST(int[] nums) {
		int length = nums.length;
		if (length == 0) {
			return null;
		} else {
			return recursion(nums, 0, length - 1);
		}
	}

	public TreeNode recursion(int[] nums, int from, int to) {
		if (from == to) {
			return new TreeNode(from);
		} else if (from == to - 1) {
			TreeNode node = new TreeNode(nums[to]);
			node.left = new TreeNode(nums[from]);
			return node;
		} else {
			int length = to - from + 1, offset = length / 2;
			TreeNode node = new TreeNode(nums[from + offset]);
			node.left = recursion(nums, from, from + offset - 1);
			node.right = recursion(nums, from + offset + 1, to);
			return node;
		}
	}

}
