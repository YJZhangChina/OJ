package leetcode.java.dp;

import leetcode.java.util.Util;

public class P673 {

    public static void main(String[] args) {
        new P673().findNumberOfLIS(new int[] {1,3,5,4,7});
        new P673().findNumberOfLIS(new int[] {2,2,2,2,2});
    }

    public int findNumberOfLIS(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return length;
        }
        int count = 0, max = Integer.MIN_VALUE;
        int[] status = new int[length];
        for (int i = 0; i < length; ++i) {
            status[i] = 1;
            for (int j = 0; j < i; ++j) {
                status[i] = nums[i] > nums[j] ? Math.max(status[j] + 1, status[i]) : status[i];
                if (status[i] > max) {
                    count = 1;
                    max = status[i];
                } else if (status[i] == max) {
                    ++count;
                }
            }
        }
        Util.print(status);
        return count;
    }

}
