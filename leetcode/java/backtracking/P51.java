package leetcode.java.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P51 {

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> ans = new ArrayList<>();
		backtrackting(0, n, new boolean[n][n], ans);
		return ans;
	}

	public void backtrackting(int level, int length, boolean[][] locations, List<List<String>> ans) {
		if (level == length) {
			ans.add(generate(locations, length));
		} else {
			for (int i = 0; i < length; ++i) {
				if (judge(locations, length, level, i)) {
					boolean[][] copy = clone(locations, length);
					copy[level][i] = true;
					backtrackting(level + 1, length, copy, ans);
				}
			}
		}
	}

	public boolean judge(boolean[][] locations, int length, int x, int y) {
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
		for (int i = 0, j = Math.min(x, length - 1 - y); i < j; ++i) {
			if (locations[x - i - 1][y + i + 1]) {
				return false;
			}
		}
		return true;
	}

	public List<String> generate(boolean[][] locations, int length) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < length; ++i) {
			char[] chars = new char[length];
			for (int j = 0; j < length; ++j) {
				chars[j] = locations[i][j] ? 'Q' : '.';
			}
			list.add(new String(chars));
		}
		return list;
	}

	public boolean[][] clone(boolean[][] locations, int length) {
		boolean[][] copy = new boolean[length][length];
		for (int i = 0; i < length; ++i) {
			copy[i] = Arrays.copyOf(locations[i], length);
		}
		return copy;
	}

}
