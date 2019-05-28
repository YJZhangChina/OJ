package leetcode.java.dp;

public class P300 {

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return length;
        }
        int[] status = new int[length];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < length; ++i) {
            status[i] = 1;
            for (int j = 0; j < i; ++j) {
                status[i] = nums[i] > nums[j] ? Math.max(status[j] + 1, status[i]) : status[i];
            }
            ans = Math.max(ans, status[i]);
        }
        return ans;
    }

}
