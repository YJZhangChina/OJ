package leetcode.java.dfs;

import leetcode.java.util.TreeNode;

public class P572 {

	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s != null && t != null) {
			return dfs(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
		} else if (s == null && t == null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean dfs(TreeNode s, TreeNode t) {
		if (s != null && t != null) {
			return s.val == t.val && dfs(s.left, t.left) && dfs(s.right, t.right);
		} else if (s == null && t == null) {
			return true;
		} else {
			return false;
		}
	}

}
