package leetcode.java.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P17 {

	private static final char[][] chars = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' }, };

	public List<String> letterCombinations(String digits) {
		List<String> ans = new LinkedList<>();
		if(digits.isEmpty()) {
			return ans;
		}
		int length = digits.length();
		int[] nums = new int[length];
		for (int i = 0; i < length; ++i) {
			nums[i] = digits.charAt(i) - '2';
		}
		backtracking(new char[length], nums, 0, length, ans);
		return ans;
	}

	public void backtracking(char[] from, int[] nums, int index, int length, List<String> list) {
		if (index == length) {
			list.add(String.valueOf(from));
		} else {
			int num = nums[index];
			for (int i = 0, j = chars[num].length; i < j; i++) {
				char[] to = Arrays.copyOf(from, length);
				to[index] = chars[num][i];
				backtracking(to, nums, index + 1, length, list);
			}
		}
	}

}
