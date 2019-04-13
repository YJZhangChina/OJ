package leetcode.java.dfs;

import leecode.java.util.TreeNode;

public class P988 {

    String ans = null;

	public String smallestFromLeaf(TreeNode root) {
		if (root != null) {
			dfs(root, "");
		}
		if (ans == null) {
			ans = "";
		}
		return ans;
	}

	public void dfs(TreeNode root, String prev) {
		String next = String.valueOf((char) (root.val + 97)) + prev;
		if (root.left == null && root.right == null) {
			if (ans == null) {
				ans = next;
			} else {
				ans = next.compareTo(ans) < 0 ? next : ans;
			}
		}
		if (root.left != null) {
			dfs(root.left, next);
		}
		if (root.right != null) {
			dfs(root.right, next);
		}
	}
}
