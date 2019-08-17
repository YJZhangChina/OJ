package leetcode.java.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class P994 {

	public int orangesRotting(int[][] grid) {
		int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1, }, { 0, 1 } };
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int m = grid.length, n = grid[0].length, fresh = 0, count = 0;
		boolean[][] status = new boolean[m][n];
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				int value = grid[i][j];
				if (value == 1) {
					++fresh;
				} else {
					if (value == 2) {
						queue.add(new int[] { i, j });
					}
					status[i][j] = true;
				}
			}
		}
		while (!queue.isEmpty() && fresh != 0) {
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				int[] entry = queue.poll();
				for (int j = 0; j < 4; ++j) {
					int x = entry[0] + directions[j][0], y = entry[1] + directions[j][1];
					if (x >= 0 && x < m && y >= 0 && y < n && !status[x][y] && grid[x][y] == 1) {
						queue.add(new int[] { x, y });
						--fresh;
						status[x][y] = true;
					}
				}
			}
			++count;
		}
		return fresh == 0 ? count : -1;
	}

}
