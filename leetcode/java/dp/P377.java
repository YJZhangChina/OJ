package leetcode.java.dp;

public class P377 {

    public int combinationSum4(int[] nums, int target) {
        int[] status = new int[target + 1];
        status[0] = 1;
        for(int i = 0; i < target; ++i) {
            for(int num : nums) {
                if(i + 1 -num >= 0) {
                    status[i + 1] += status[i + 1 - num];
                }
            }
        }
        return status[target];
    }

}
