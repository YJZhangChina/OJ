package leetcode.java.backtracking;

import java.util.LinkedList;
import java.util.List;

public class P22 {

	public List<String> generateParenthesis(int n) {
		List<String> ans = new LinkedList<>();
		if (n < 1) {
			return ans;
		}
		backtracking(n, 0, 0, n, new char[n * 2], ans);
		return ans;
	}

	public void backtracking(int l, int r, int i, int n, char[] track, List<String> ans) {
		if (i == n * 2) {
			ans.add(new String(track));
		} else {
			if (l > 0) {
				char[] newTrack = track.clone();
				newTrack[i] = '(';
				backtracking(l - 1, r, i + 1, n, newTrack, ans);
			}
			if (r < n - l) {
				char[] newTrack = track.clone();
				newTrack[i] = ')';
				backtracking(l, r + 1, i + 1, n, newTrack, ans);
			}
		}
	}

}
