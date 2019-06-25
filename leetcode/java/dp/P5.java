package leetcode.java.dp;

public class P5 {

	public String longestPalindrome(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		int length = s.length();
		boolean[][] status = new boolean[length][length];
		int x = -1, y = -1;
		for (int j = 0; j < length; ++j) {
			for (int i = j; i < length; ++i) {
				if (j == 0) {
					status[i][j] = true;
				} else if (j == 1) {
					status[i][j] = s.charAt(i - 1) == s.charAt(i) ? true : false;
				} else {
					status[i][j] = status[i - 1][j - 2] && s.charAt(i - j) == s.charAt(i) ? true : false;
				}
				if (status[i][j] && y != j) {
					x = i - j;
					y = j;
				}
			}
		}
		return s.substring(x, x + y + 1);
	}

}
