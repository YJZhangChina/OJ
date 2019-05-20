package leetcode.java.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetcode.java.Util;

public class P77 {

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ans = new LinkedList<>();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}
		if (n < k || !(k > 0)) {
			return ans;
		}
		backtracking(k, nums.length, nums, new ArrayList<>(), ans);
		return ans;
	}

	public void backtracking(int current, int range, int[] nums, List<Integer> track, List<List<Integer>> ans) {
		if (current == 0) {
			ans.add(track);
		} else {
			for (int i = range - 1; i >= current - 1; --i) {
				int num = nums[i];
				List<Integer> newTrack = new ArrayList<>(track.size() + 1);
				newTrack.add(num);
				newTrack.addAll(track);
				backtracking(current - 1, i, nums, newTrack, ans);
			}

		}
	}

}
