package leetcode.java.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P40 {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ans = new LinkedList<>();
		Arrays.sort(candidates);
		backtracking(target, candidates.length, candidates, new ArrayList<>(), ans);
		return ans;
	}

	public void backtracking(int current, int range, int[] candidates, List<Integer> track, List<List<Integer>> ans) {
		if (current == 0) {
			ans.add(track);
		} else if (current > 0) {
			boolean flag = false;
			int previous = -1;
			for (int i = range - 1; i >= 0; --i) {
				int candidate = candidates[i];
				if (!flag || previous != candidate) {
					List<Integer> newTrack = new ArrayList<>(track.size() + 1);
					newTrack.add(candidate);
					newTrack.addAll(track);
					backtracking(current - candidate, i, candidates, newTrack, ans);
					previous = candidate;
					flag = true;
				} else {
					continue;
				}
			}
		}
	}

}
