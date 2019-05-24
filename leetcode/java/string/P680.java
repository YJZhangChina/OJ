package leetcode.java.string;

public class P680 {

	public boolean validPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				++i;
				--j;
			} else {
				return check(s, i + 1, j) || check(s, i, j - 1);
			}
		}
		return true;
	}

	public boolean check(String string, int from, int to) {
		int i = from, j = to;
		while (i < j) {
			if (string.charAt(i) != string.charAt(j)) {
				return false;
			}
			++i;
			--j;
		}
		return true;
	}

}
