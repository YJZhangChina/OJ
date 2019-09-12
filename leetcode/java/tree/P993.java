package leetcode.java.tree;

import leetcode.java.util.TreeNode;

public class P993 {

	private boolean foundX = false, foundY = false;
	private TreeNode parentX = null, parentY = null;
	private int levelX = -1, levelY = 1;

	public boolean isCousins(TreeNode root, int x, int y) {
		dfs(root, null, 0, x, y);
		return (parentX != parentY) && (levelX == levelY);
	}

	public void dfs(TreeNode child, TreeNode parent, int level, int x, int y) {
		if (child == null || (foundX && foundY)) {
			return;
		}
		if (child.val == x) {
			parentX = parent;
			levelX = level;
		} else if (child.val == y) {
			parentY = parent;
			levelY = level;
		}
		dfs(child.left, child, level + 1, x, y);
		dfs(child.right, child, level + 1, x, y);
	}

}
