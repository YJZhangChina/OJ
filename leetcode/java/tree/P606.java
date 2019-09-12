package leetcode.java.tree;

import leetcode.java.util.TreeNode;

public class P606 {

	public String tree2str(TreeNode t) {
		if (t == null) {
			return "";
		}
		String val = String.valueOf(t.val);
		if (t.left == null && t.right == null) {
			return val;
		}
		String left = tree2str(t.left), right = tree2str(t.right);
		return val + "(" + left + ")" + (!right.isEmpty() ? ("(" + right + ")") : "");
	}
	
}
