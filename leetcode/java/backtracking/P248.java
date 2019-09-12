package leetcode.java.backtracking;

public class P248 {

	private static final char[][] pairs = { { '0', '0' }, { '1', '1' }, { '6', '9' }, { '8', '8' }, { '9', '6' } };

	public int strobogrammaticInRange(String low, String high) {
		int[] count = { 0 };
		for (int len = low.length(); len <= high.length(); len++) {
			char[] c = new char[len];
			dfs(low, high, c, 0, len - 1, count);
		}
		return count[0];
	}

	public void dfs(String low, String high, char[] chars, int left, int right, int[] count) {
		if (left > right) {
			String s = new String(chars);
			if ((s.length() == low.length() && s.compareTo(low) < 0)
					|| (s.length() == high.length() && s.compareTo(high) > 0)) {
				return;
			}
			count[0]++;
			return;
		}
		for (char[] p : pairs) {
			chars[left] = p[0];
			chars[right] = p[1];
			if (chars.length != 1 && chars[0] == '0') {
				continue;
			}
			if (left == right && p[0] != p[1]) {
				continue;
			}
			dfs(low, high, chars, left + 1, right - 1, count);
		}
	}

}
