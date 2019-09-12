package leetcode.java.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P293 {

	public List<String> generatePossibleNextMoves(String string) {
		List<String> ans = new ArrayList<String>();
		char[] chars = string.toCharArray();
		int length = chars.length;
		for (int i = 0, j = length - 1; i < j; ++i) {
			if (chars[i] == '+' && chars[i + 1] == '+') {
				char[] copy = Arrays.copyOf(chars, length);
				Arrays.fill(copy, i, i + 2, '-');
				ans.add(String.valueOf(copy));
			}
		}
		return ans;
	}

}
