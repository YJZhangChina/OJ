package leetcode.java.dfs;

import leetcode.java.util.TreeNode;

public class P437 {

	int ans = 0;

	public int pathSum(TreeNode root, int sum) {
		search(root, sum);
		return ans;
	}

	public void search(TreeNode root, int sum) {
		if (root != null) {
			dfs(root, sum);
			search(root.left, sum);
			search(root.right, sum);
		}
	}

	public void dfs(TreeNode root, int target) {
		if (root == null) {
			return;
		}
		if (root.val == target) {
			ans += 1;
		}
		dfs(root.left, target - root.val);
		dfs(root.right, target - root.val);
	}

}
