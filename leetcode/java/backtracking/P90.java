package leetcode.java.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P90 {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < nums.length + 1; i++) {
			backtracking(i, nums.length, nums, new ArrayList<>(), ans);
		}
		return ans;
	}

	public void backtracking(int current, int range, int[] nums, List<Integer> track, List<List<Integer>> ans) {
		if (current == 0) {
			ans.add(track);
		} else {
			boolean flag = false;
			int previous = -1;
			for (int i = range - 1; i >= current - 1; --i) {
				int num = nums[i];
				if (!flag || previous != num) {
					List<Integer> newTrack = new ArrayList<>(track.size() + 1);
					newTrack.add(num);
					newTrack.addAll(track);
					backtracking(current - 1, i, nums, newTrack, ans);
					previous = num;
					flag = true;
				} else {
					continue;
				}
			}
		}
	}

}
