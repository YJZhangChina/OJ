package leetcode.java.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P785 {

	public boolean isBipartite(int[][] ints) {
		Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
		for (int i = 0; i < ints.length; i++) {
			for (int j = 0; j < ints[i].length; j++) {
				put(graph, i, ints[i][j]);
				put(graph, ints[i][j], i);
			}
		}
		Map<Integer, Integer> colors = new HashMap<Integer, Integer>();
		for (int node : graph.keySet()) {
			if (!colors.containsKey(node) && !dfs(node, 0, graph, colors)) {
				return false;
			}
		}
		return true;
	}

	public void put(Map<Integer, Set<Integer>> graph, int node, int neighbor) {
		if (graph.containsKey(node)) {
			graph.get(node).add(neighbor);
		} else {
			Set<Integer> set = new HashSet<Integer>();
			set.add(neighbor);
			graph.put(node, set);
		}
	}

	public boolean dfs(int node, int color, Map<Integer, Set<Integer>> graph, Map<Integer, Integer> colors) {
		if (colors.containsKey(node)) {
			return color == colors.get(node);
		}
		colors.put(node, color);
		for (int neighbor : graph.get(node)) {
			if (!dfs(neighbor, color ^ 1, graph, colors)) {
				return false;
			}
		}
		return true;
	}

}
