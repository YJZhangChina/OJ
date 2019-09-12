package leetcode.java.dp;

import leetcode.java.util.Util;

public class P161 {

	public static void main(String[] args) {
		System.out.println(new P161().isOneEditDistance("ab", "acb"));
		System.out.println(new P161().isOneEditDistance("cab", "ad"));
		System.out.println(new P161().isOneEditDistance("1203", "1213"));
	}

	// 249

	public boolean isOneEditDistance(String s, String t) {
		int m = s.length(), n = t.length();
		int[][] status = new int[m + 1][n + 1];
		for (int i = 0; i < m; ++i) {
			status[i + 1][0] = i + 1;
		}
		for (int j = 0; j < n; ++j) {
			status[0][j + 1] = j + 1;
		}
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				status[i + 1][j + 1] = Math.min(Math.min(status[i + 1][j], status[i][j + 1]) + 1,
						status[i][j] + (s.charAt(i) == t.charAt(j) ? 0 : 1));
			}
		}
		return status[m][n] == 1;
	}

}
