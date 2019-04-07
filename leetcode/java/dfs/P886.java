package leetcode.java.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P886 {

	public boolean possibleBipartition(int N, int[][] dislikes) {
		@SuppressWarnings("unchecked")
		List<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; ++i) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int[] edge : dislikes) {
			graph[edge[0]].add(edge[1]);
			graph[edge[1]].add(edge[0]);
		}
		Map<Integer, Integer> colors = new HashMap<Integer, Integer>(N + 1);
		for (int i = 1; i <= N; ++i) {
			if (!colors.containsKey(i) && !dfs(i, 0, graph, colors)) {
				return false;
			}
		}
		return true;
	}

	public boolean dfs(int node, int color, List<Integer>[] graph, Map<Integer, Integer> colors) {
		if (colors.containsKey(node)) {
			return colors.get(node) == color;
		}
		colors.put(node, color);
		for (int neighbor : graph[node]) {
			if (!dfs(neighbor, color ^ 1, graph, colors)) {
				return false;
			}
		}
		return true;
	}

}
