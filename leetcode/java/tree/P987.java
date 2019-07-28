package leetcode.java.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import leetcode.java.util.TreeNode;

public class P987 {

	private List<P987TreeNode> nodes = new ArrayList<>();

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> results = new ArrayList<>();
		nodes.clear();
		dfs(root, 0, 0);
		Collections.sort(nodes);
		boolean first = true;
		int privious = -1;
		for (P987TreeNode node : nodes) {
			if (first || privious != node.x) {
				first = false;
				privious = node.x;
				results.add(new ArrayList<>());
			}
			results.get(results.size() - 1).add(node.val);
		}
		return results;
	}

	private void dfs(TreeNode node, int x, int y) {
		if (node == null) {
			return;
		}
		nodes.add(new P987TreeNode(node.val, x, y));
		dfs(node.left, x - 1, y + 1);
		dfs(node.right, x + 1, y + 1);
	}

	class P987TreeNode implements Comparable<P987TreeNode> {

		private int val, x, y;

		private P987TreeNode(int val, int x, int y) {
			this.val = val;
			this.x = x;
			this.y = y;

		}

		@Override
		public int compareTo(P987TreeNode node) {
			return x == node.x ? y == node.y ? Integer.compare(val, node.val) : Integer.compare(y, node.y)
					: Integer.compare(x, node.x);
		}
	};

}
