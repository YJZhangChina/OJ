package leetcode.java.tree;

import java.util.Stack;

import leetcode.java.util.TreeNode;

public class P1008 {

	public TreeNode bstFromPreorder(int[] preorder) {
		TreeNode root = null;
		Stack<TreeNode> stack = new Stack<>();
		for (int i = 0, j = preorder.length; i < j; ++i) {
			TreeNode node = new TreeNode(preorder[i]);
			if (stack.isEmpty()) {
				stack.push(node);
				root = node;
			} else if (node.val < stack.peek().val) {
				stack.peek().left = node;
				stack.push(node);
			} else {
				TreeNode top = null;
				while (!stack.isEmpty() && stack.peek().val < node.val) {
					top = stack.pop();
				}
				top.right = node;
				stack.push(node);
			}
		}
		return root;
	}

}
