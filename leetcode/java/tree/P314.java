package leetcode.java.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import leetcode.java.util.TreeNode;

public class P314 {

	private int index;

	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		List<P314Node> nodes = new ArrayList<P314Node>();
		index = 0;
		dfs(root, 0, 0, nodes);
		Collections.sort(nodes);
		boolean first = true;
		int previous = -1;
		for (P314Node node : nodes) {
			if (first || previous != node.x) {
				ans.add(new ArrayList<>());
				first = false;
				previous = node.x;
			}
			ans.get(ans.size() - 1).add(node.val);
		}
		return ans;
	}

	public void dfs(TreeNode node, int x, int y, List<P314Node> nodes) {
		if (node == null) {
			return;
		}
		dfs(node.left, x - 1, y + 1, nodes);
		nodes.add(new P314Node(node.val, x, y, index));
        ++index;
		dfs(node.right, x + 1, y + 1, nodes);
	}

	private class P314Node implements Comparable<P314Node> {

		private int val, x, y, level;

		private P314Node(int val, int x, int y, int level) {
			this.val = val;
			this.x = x;
			this.y = y;
			this.level = level;
		}

		@Override
		public int compareTo(P314Node node) {
			return x == node.x ? y == node.y ? level - node.level : y - node.y : x - node.x;
		}
        
	}

}
