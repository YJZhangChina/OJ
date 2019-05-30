package leetcode.java.backtracking;

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
            int previous = -1;
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

    private int[] next(int[] track, int index) {
        int length = track.length;
        int[] next = new int[length - 1];
        System.arraycopy(track, 0, next, 0, index);
        System.arraycopy(track, index + 1, next, index, length - index - 1);
        return next;
    }

}
