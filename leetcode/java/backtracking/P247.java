package leetcode.java.backtracking;

import java.util.ArrayList;
import java.util.List;

public class P247 {

	private static final char[] keys = { '0', '1', '8', '6', '9' };
	private static final char[] vals = { '0', '1', '8', '9', '6' };
	private static final int MIDDLE = 2;

	public List<String> findStrobogrammatic(int n) {
		List<String> result = new ArrayList<>();
		char[] path = new char[n];
		helper(n, 0, result, path);
		return result;
	}

	private void helper(final int n, int i, List<String> result, char[] path) {
		if (i > n - i - 1) {
			result.add(new String(path));
		}
		for (int p = 0, q = keys.length; p < q; p++) {
			if (p == 0 && i == 0 && n != 1) {
				continue;
			}
			if ((i < n - i - 1) || (i == n - i - 1 && p <= MIDDLE)) {
				path[i] = keys[p];
				path[n - i - 1] = vals[p];
				helper(n, i + 1, result, path);
			}
		}
	}

}
