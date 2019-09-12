package leetcode.java.dfs;

import java.util.Arrays;

public class P52 {

	private int ans;

	public int totalNQueens(int n) {
		dfs(0, n, new boolean[n][n]);
		return ans;
	}

	public void dfs(int level, int n, boolean[][] locations) {
		if (level == n) {
			ans += 1;
		} else {
			for (int i = 0; i < n; ++i) {
				if (judge(locations, level, i, n)) {
					boolean[][] copy = clone(locations, n);
					copy[level][i] = true;
					dfs(level + 1, n, copy);
				}
			}
		}
	}

	public boolean judge(boolean[][] locations, int x, int y, int n) {
		for (int i = 0; i < x; ++i) {
			if (locations[i][y]) {
				return false;
			}
		}
		for (int i = 0, j = Math.min(x, y); i < j; ++i) {
			if (locations[x - i - 1][y - i - 1]) {
				return false;
			}
		}
		for (int i = 0, j = Math.min(x, n - 1 - y); i < j; ++i) {
			if (locations[x - i - 1][y + i + 1]) {
				return false;
			}
		}
		return true;
	}

	public boolean[][] clone(boolean[][] booleans, int n) {
		boolean[][] copy = new boolean[n][n];
		for (int i = 0; i < n; ++i) {
			copy[i] = Arrays.copyOf(booleans[i], n);
		}
		return copy;
	}

}
