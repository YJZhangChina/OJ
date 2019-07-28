package leetcode.java.tree;

import java.util.HashMap;
import java.util.Map;

import leetcode.java.util.TreeNode;

public class P662 {

	private int ans = -1;
	private Map<Integer, Integer> map = new HashMap<>();

	public int widthOfBinaryTree(TreeNode root) {
		dfs(root, 1, 1);
		return ans;
	}

	public void dfs(TreeNode node, int x, int y) {
		if (node == null) {
			return;
		}
		dfs(node.left, x * 2 - 1, y + 1);
		if (!map.containsKey(y)) {
			map.put(y, x);
		}
		ans = Math.max(ans, x - map.get(y) + 1);
		dfs(node.right, x * 2, y + 1);
	}

}
