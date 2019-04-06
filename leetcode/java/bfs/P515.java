package leetcode.java.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leecode.java.util.TreeNode;

public class P515 {

	public List<Integer> largestValues(TreeNode root) {
		List<Integer> ans = new LinkedList<Integer>();
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			while (!queue.isEmpty()) {
				int max = Integer.MIN_VALUE;
				for (int i = 0, size = queue.size(); i < size; i++) {
					TreeNode node = queue.poll();
					max = Math.max(max, node.val);
					if (node.left != null) {
						queue.add(node.left);
					}
					if (node.right != null) {
						queue.add(node.right);
					}
				}
				ans.add(max);
			}
		}
		return ans;
	}

}
