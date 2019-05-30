package leetcode.java.backtracking;

import leetcode.java.util.Util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        if (nums.length < 1) {
            return ans;
        }
        Arrays.sort(nums);
        backtracking(nums, new Integer[nums.length], 0, ans);
        return ans;
    }

    public void backtracking(int[] nums, Integer[] track, int index, List<List<Integer>> ans) {
        if (nums.length == 1) {
            track[index] = nums[0];
            ans.add(Arrays.asList(track));
        } else {
            boolean flag = false;
            Integer previous = -1;
            for (int i = 0, j = nums.length; i < j; ++i) {
                int value = nums[i];
                if (!flag || previous != value) {
                    int[] newNums = next(nums, i);
                    Integer[] newTrack = new Integer[track.length];
                    System.arraycopy(track, 0, newTrack, 0, index);
                    newTrack[index] = value;
                    backtracking(newNums, newTrack, index + 1, ans);
                    previous = value;
                    flag = true;
                }
            }
        }
    }

    public int[] next(int[] track, int index) {
        int length = track.length, current = 0;
        int[] next = new int[length - 1];
        for (int i = 0; i < index; ++i) {
            next[i] = track[i];
        }
        for (int i = index + 1; i < length; ++i) {
            next[i - 1] = track[i];
        }
        return next;
    }

}
