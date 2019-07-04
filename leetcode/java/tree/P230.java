package leetcode.java.tree;

import java.util.Stack;

import leetcode.java.util.TreeNode;

public class P230 {

	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (true) {
			while (root != null) {
				stack.add(root);
				root = root.left;
			}
			root = stack.pop();
			if (--k == 0) {
				return root.val;
			}
			root = root.right;
		}
	}

}
