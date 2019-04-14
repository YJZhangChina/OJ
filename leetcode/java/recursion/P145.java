package leetcode.java.recursion;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import leecode.java.util.TreeNode;

public class P145 {

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ans = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root != null) {
			stack.add(root);
		}
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			ans.add(node.val);
			if (node.left != null) {
				stack.push(node.left);
			}
			if (node.right != null) {
				stack.push(node.right);
			}
		}
		Collections.reverse(ans);
		return ans;
	}

}
