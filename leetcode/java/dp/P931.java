package leetcode.java.dp;

public class P931 {

	public static void main(String[] args) {
		// 12
		System.out.println(new P931().minFallingPathSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
		// -98
		System.out.println(
				new P931().minFallingPathSum(new int[][] { { -51, -35, 74 }, { -62, 14, -53 }, { 94, 61, -10 } }));
		// -66
		System.out.println(
				new P931().minFallingPathSum(new int[][] { { -80, -13, 22 }, { 83, 94, -5 }, { 73, -48, 61 } }));

	}

	public int minFallingPathSum(int[][] A) {
		int length = A.length;
		if (length == 0) {
			return 0;
		}
		if (length == 1) {
			return A[0][0];
		}
		int[][] status = new int[length][length];
		System.arraycopy(A[0], 0, status[0], 0, length);
		for (int i = 1; i < length; ++i) {
			status[i][0] = A[i][0] + Math.min(status[i - 1][0], status[i - 1][1]);
			status[i][length - 1] = A[i][length - 1]
					+ Math.min(status[i - 1][length - 1 - 1], status[i - 1][length - 1]);
			for (int j = 1, k = length - 1; j < k; ++j) {
				status[i][j] = A[i][j]
						+ Math.min(status[i - 1][j], Math.min(status[i - 1][j - 1], status[i - 1][j + 1]));
			}
		}
		Integer ans = Integer.MAX_VALUE;
		for (int i : status[length - 1]) {
			ans = Math.min(ans, i);
		}
		return ans;
	}

}
