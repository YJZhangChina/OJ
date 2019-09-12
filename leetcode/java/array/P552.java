package leetcode.java.array;

public class P552 {

	/**
	 * At n = 2: 0A0L: PP, LP (2); 0A1L: PL (1); 0A2L: LL (1); 1A0L: AP, LP, LA (3);
	 * 1A1L: AL (1); 1A2L: (0)
	 * 
	 * @param n
	 * @return
	 */
	public int checkRecord(int n) {
		int mod = 1000000007;
		if (n == 1) {
			return 3;
		}
		if (n == 2) {
			return 8;
		}
		long[][] status = new long[n][6];
		status[1][0] = 2;
		status[1][1] = 1;
		status[1][2] = 1;
		status[1][3] = 3;
		status[1][4] = 1;
		status[1][5] = 0;
		for (int i = 2; i < n; ++i) {
			status[i][0] = (status[i - 1][0] + status[i - 1][1] + status[i - 1][2]) % mod;
			status[i][1] = status[i - 1][0];
			status[i][2] = status[i - 1][1];
			status[i][3] = (status[i - 1][0] + status[i - 1][1] + status[i - 1][2] + status[i - 1][3] + status[i - 1][4]
					+ status[i - 1][5]) % mod;
			status[i][4] = status[i - 1][3];
			status[i][5] = status[i - 1][4];
		}
		return (int) ((status[n - 1][0] + status[n - 1][1] + status[n - 1][2] + status[n - 1][3] + status[n - 1][4]
				+ status[n - 1][5]) % mod);
	}

}
