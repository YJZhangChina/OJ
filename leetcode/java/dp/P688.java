package leetcode.java.dp;

public class P688 {

	final int[][] directions = { { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 }, { -2, 1 },
			{ -1, 2 }, };
	double[][][] status;

	public double knightProbability(int N, int K, int r, int c) {
		if (N < 1 || K < 1) {
			return 1.0;
		}
		status = new double[K][N][N];
		return search(N, K, r, c);
	}

	public double search(int N, int K, int r, int c) {
		if (K == 1) {
			if (status[K - 1][r][c] == 0) {
				double vaild = 0;
				for (int i = 0, j = directions.length; i < j; ++i) {
					int x = r + directions[i][0], y = c + directions[i][1];
					if (x >= 0 && x < N && y >= 0 && y < N) {
						vaild += 1;
					}
				}
				status[K - 1][r][c] = vaild / 8.0;
			}
			return status[K - 1][r][c];
		} else {
			double ans = 0;
			for (int i = 0, j = directions.length; i < j; ++i) {
				int x = r + directions[i][0], y = c + directions[i][1];
				if (x >= 0 && x < N && y >= 0 && y < N) {
					if (status[K - 1][x][y] == 0) {
						status[K - 1][x][y] = search(N, K - 1, x, y);
					}
					ans += status[K - 1][x][y] / 8.0;
				}
			}
			return ans;
		}
	}

}
