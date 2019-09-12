package leetcode.java.dp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P491 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        if(nums.length == 0) {
            return ans;
        }
        dfs(0, nums.length, nums, new ArrayList<>(), ans);
        return ans;
    }

    public void dfs(int start, int length, int[] nums, List<Integer> track, List<List<Integer>> ans)  {
        boolean flag = false;
        int value = nums[start];
        for(int i = start; i < length; ++i) {
            if(!flag || value != nums[i]) {
                value = nums[i];
                List<Integer> newTrack = new ArrayList<>(track.size() + 1);
                newTrack.addAll(track);
                newTrack.add(value);
                flag = true;
                if(newTrack.size() > 1) {
                    ans.add(newTrack);
                }
                dfs(i, length, nums, newTrack, ans);
            }
        }
    }

}
