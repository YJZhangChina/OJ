package leetcode.java.dp;

public class P647 {

	public int countSubstrings(String s) {
		int length = s.length(), ans = 0;
		boolean[][] status = new boolean[length][length];
		for (int j = 0; j < length; ++j) {
			for (int i = 0, k = length - j; i < k; ++i) {
				if (j == 0) {
					status[i][j] = true;
				} else if (j == 1) {
					status[i][j] = s.charAt(i) == s.charAt(i + 1);
				} else {
					status[i][j] = status[i + 1][j - 2] && s.charAt(i) == s.charAt(i + j);
				}
				if (status[i][j]) {
					ans += 1;
				}
			}
		}
		return ans;
	}

}
