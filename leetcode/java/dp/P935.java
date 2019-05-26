package leetcode.java.dp;

public class P935 {

	public final int mod = 1000000007;

	public final int num = 10;

	public final int[][] trans = { { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 0, 3, 9 }, {}, { 0, 1, 7 }, { 2, 6 },
			{ 1, 3 }, { 2, 4 }, };

	public int knightDialer(int N) {
		long[][] status = new long[N][num];
		for (int i = 0; i < num; ++i) {
			status[0][i] = 1;
		}
		for (int i = 1; i < N; ++i) {
			for (int j = 0; j < num; ++j) {
				for (int k = 0, l = trans[j].length; k < l; ++k) {
					status[i][trans[j][k]] += (status[i - 1][j]);
				}
				status[i][j] = status[i][j] % mod;
			}
		}
		long ans = 0;
		for (int i = 0; i < num; ++i) {
			ans += (status[N - 1][i]);
		}
		return Long.valueOf(ans % mod).intValue();
	}

}
