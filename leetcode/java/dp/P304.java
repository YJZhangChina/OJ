package leetcode.java.dp;

public class P304 {

	private int[][] cache;

	// Change 'P304' to 'NumMatrix'
	public P304(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		cache = new int[matrix.length + 1][matrix[0].length + 1];
		for (int i = 0, m = matrix.length; i < m; ++i) {
			for (int j = 0, n = matrix[0].length; j < n; ++j) {
				cache[i + 1][j + 1] = cache[i + 1][j] + cache[i][j + 1] + matrix[i][j] - cache[i][j];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return cache[row2 + 1][col2 + 1] - cache[row1][col2 + 1] - cache[row2 + 1][col1] + cache[row1][col1];
	}

}
