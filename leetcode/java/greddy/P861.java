package leetcode.java.greddy;

public class P861 {
	public int matrixScore(int[][] A) {
		int ans = 0, m = A.length, n = A[0].length;
		int[] status = new int[n];
		status[0] = m;
		for (int i = 0; i < m; ++i) {
			if (A[i][0] == 0) {
				convertRow(A, i);
			}
		}
		for (int j = 1; j < n; ++j) {
			int count = 0;
			for (int i = 0; i < m; ++i) {
				if (A[i][j] == 1) {
					count += 1;
				}
			}
			status[j] = Math.max(count, m - count);
		}
		int value = 1;
		for (int i = 0; i < n; ++i) {
			ans += value * status[m - 1 - i];
			value <<= 1;
		}
		return ans;
	}

	public void convertRow(int[][] A, int row) {
		for (int j = 0, n = A[row].length; j < n; ++j) {
			A[row][j] = A[row][j] == 0 ? 1 : 0;
		}
	}
}
