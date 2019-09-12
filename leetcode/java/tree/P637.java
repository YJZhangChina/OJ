package leetcode.java.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.java.util.TreeNode;

public class P637 {

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> ans = new ArrayList<Double>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root != null) {
			queue.add(root);
		}
		while (!queue.isEmpty()) {
			int size = queue.size();
			long sum = 0;
			for (int i = 0; i < size; ++i) {
				TreeNode node = queue.poll();
				sum += node.val;
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			ans.add((double) sum / (double) size);
		}
		return ans;
	}

}
