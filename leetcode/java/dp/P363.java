package leetcode.java.dp;

public class P363 {

	public int maxSumSubmatrix(int[][] matrix, int k) {
		int m = matrix.length, n = matrix[0].length;
		int[][] status = new int[m + 1][n + 1];
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				status[i + 1][j + 1] = status[i + 1][j] + status[i][j + 1] - status[i][j] + matrix[i][j];
				if (status[i + 1][j + 1] == k) {
					return k;
				}
			}
		}
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				for (int p = i + 1, x = m + 1; p < x; ++p) {
					for (int q = j + 1, y = n + 1; q < y; ++q) {
						int value = status[p][q] - status[i][q] - status[p][j] + status[i][j];
						if (value == k) {
							return k;
						}
						if (value < k) {
							ans = Math.max(ans, value);
						}
					}
				}
			}
		}
		return ans;
	}

}
