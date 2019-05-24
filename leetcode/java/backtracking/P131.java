package leetcode.java.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P131 {

	public List<List<String>> partition(String s) {
		List<List<String>> ans = new LinkedList<>();
		if (s == null || s.isEmpty()) {
			return ans;
		}
		backtracking(0, s.length(), s, new ArrayList<>(), ans);
		return ans;
	}

	public void backtracking(int start, int length, String string, List<String> track, List<List<String>> ans) {
		if (start == length) {
			ans.add(track);
		}
		if (start < length) {
			for (int i = start + 1, j = length + 1; i < j; ++i) {
				String current = string.substring(start, i);
				if (isPalindromic(current)) {
					List<String> newTrack = new ArrayList<>(track.size() + 1);
					newTrack.addAll(track);
					newTrack.add(current);
					backtracking(i, length, string, newTrack, ans);
				}
			}
		}
	}

	public boolean isPalindromic(String string) {
		int i = 0, j = string.length() - 1;
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
