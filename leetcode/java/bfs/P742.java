package leetcode.java.bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import leetcode.java.util.TreeNode;

public class P742 {

	public int findClosestLeaf(TreeNode root, int k) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		Set<Integer> leaves = new HashSet<>(), visited = new HashSet<>();
		graph.put(root.val, new HashSet<>());
		dfs(root, graph, leaves);
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(k);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				int val = queue.poll();
				visited.add(val);
				if (leaves.contains(val)) {
					return val;
				}
				for (int next : graph.get(val)) {
					if (!visited.contains(next)) {
						visited.add(next);
						queue.add(next);
					}
				}
			}
		}
		return -1;
	}

	public void dfs(TreeNode node, Map<Integer, Set<Integer>> graph, Set<Integer> leaves) {
		if (node.left == null && node.right == null) {
			leaves.add(node.val);
		} else {
			if (node.left != null) {
				if (!graph.containsKey(node.left.val)) {
					graph.put(node.left.val, new HashSet<>());
				}
				graph.get(node.val).add(node.left.val);
				graph.get(node.left.val).add(node.val);
				dfs(node.left, graph, leaves);
			}
			if (node.right != null) {
				if (!graph.containsKey(node.right.val)) {
					graph.put(node.right.val, new HashSet<>());
				}
				graph.get(node.val).add(node.right.val);
				graph.get(node.right.val).add(node.val);
				dfs(node.right, graph, leaves);
			}
		}
	}

}
