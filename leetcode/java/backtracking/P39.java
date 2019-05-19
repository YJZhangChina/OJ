package leetcode.java.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P39 {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new LinkedList<>();
		Arrays.sort(candidates);
		backtracking(candidates, target, candidates[candidates.length - 1], new ArrayList<>(), ans);
		return ans;
	}

	public void backtracking(int[] candidates, int target, int maxium, List<Integer> track, List<List<Integer>> ans) {
		for (int i = 0, j = candidates.length; i < j; i++) {
			int candidate = candidates[j - 1 - i];
			if (candidate <= maxium && !(candidate > target)) {
				List<Integer> list = new ArrayList<>(track.size() + 1);
				if (target == candidate) {
					list.add(target);
					list.addAll(track);
					ans.add(list);
				} else if (target > candidate) {
					list.add(candidate);
					list.addAll(track);
					backtracking(candidates, target - candidate, candidate, list, ans);
				}
			}
		}
	}
	
}
