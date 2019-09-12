package leetcode.java.dp;

public class P10 {

	public boolean isMatch(String s, String p) {
		int m = s.length(), n = p.length();
		boolean[][] status = new boolean[m + 1][n + 1];
		status[0][0] = true;
		for (int j = 0, k = n - 1; j < k; ++j) {
			if (p.charAt(j + 1) == '*') {
				status[0][j + 2] = status[0][j];
			}
		}
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
					status[i + 1][j + 1] = status[i][j];
				} else if (p.charAt(j) == '*') {
					status[i + 1][j + 1] = status[i + 1][j - 1];
					if(p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i)) {
						status[i + 1][j + 1] = status[i + 1][j + 1]||status[i][j+ 1];
					}
				}
			}
		}
		return status[m][n];
	}

}
