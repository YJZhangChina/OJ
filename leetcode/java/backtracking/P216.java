package leetcode.java.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P216 {

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ans = new LinkedList<>();
		backtracking(n, k, 9, new ArrayList<>(), ans);
		return ans;
	}

	public void backtracking(int current, int time, int range, List<Integer> track, List<List<Integer>> ans) {
		if (current == 0 && time == 0) {
			ans.add(track);
		} else if (current > 0 && time > 0) {
			for (int i = range; i > 0; --i) {
				int num = i;
				List<Integer> newTrack = new ArrayList<>(track.size() + 1);
				newTrack.add(num);
				newTrack.addAll(track);
				backtracking(current - num, time - 1, i - 1, newTrack, ans);
			}
		}
	}

}
