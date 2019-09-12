package leetcode.java.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.java.util.TreeNode;

public class P103 {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		Stack<TreeNode> from = new Stack<>(), to = new Stack<>();
		if (root != null) {
			from.push(root);
		}
		while (!from.isEmpty() || !to.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			TreeNode node = null;
			while (!from.isEmpty()) {
				node = from.pop();
				level.add(node.val);
				if (node.left != null)
					to.push(node.left);
				if (node.right != null)
					to.push(node.right);
			}
			ans.add(level);
			level = new ArrayList<Integer>();
			while (!to.isEmpty()) {
				node = to.pop();
				level.add(node.val);
				if (node.right != null)
					from.push(node.right);
				if (node.left != null)
					from.push(node.left);
			}
			if (!level.isEmpty())
				ans.add(level);
		}
		return ans;
	}

}
