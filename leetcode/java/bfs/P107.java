package leetcode.java.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import leetcode.java.util.TreeNode;

public class P107 {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ans = new LinkedList<>();
		if (root == null) {
			return ans;
		}
		Stack<List<Integer>> stack = new Stack<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<>(size);
			for (int i = 0; i < size; ++i) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			stack.add(list);
		}
		while (!stack.isEmpty()) {
			ans.add(stack.pop());
		}
		return ans;
	}

}
