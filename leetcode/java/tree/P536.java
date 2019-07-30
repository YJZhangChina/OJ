package leetcode.java.tree;

import java.util.Stack;

import leetcode.java.util.TreeNode;

public class P536 {

	public TreeNode str2tree(String s) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode root = null;
		for (int i = 0, j = s.length(), k = i; i < j; ++i, k = i) {
			char c = s.charAt(i);
			if (c == ')') {
				stack.pop();
			} else if ((c >= '0' && c <= '9') || c == '-') {
				while (i + 1 < j && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
					++i;
				}
				TreeNode node = new TreeNode(Integer.valueOf(s.substring(k, i + 1)));
				if (root == null) {
					root = node;
				}
				if (!stack.isEmpty()) {
					TreeNode parent = stack.peek();
					if (parent.left != null) {
						parent.right = node;
					} else {
						parent.left = node;
					}
				}
				stack.push(node);
			}
		}
		return root;
	}

}
