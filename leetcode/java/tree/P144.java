package leetcode.java.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.java.util.TreeNode;

public class P144 {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		while (stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		return list;
	}

}
