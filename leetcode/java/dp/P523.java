package leetcode.java.dp;

import leetcode.java.util.Util;

public class P523 {

    public static void main(String[] args) {
        System.out.println(new P523().checkSubarraySum(new int[] {23, 2, 6, 4, 7}, 0));
        System.out.println(new P523().checkSubarraySum(new int[] {1, 0, 1, 0, 1}, 4));
        System.out.println(new P523().checkSubarraySum(new int[] {0, 1, 0}, 0));
        System.out.println(new P523().checkSubarraySum(new int[] {0, 0}, -1));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int length = nums.length;
        if (length < 2) {
            return false;
        }
        int[] cache = new int[length + 1];
        for(int i = 0; i < length; ++i) {
            cache[i + 1] = cache[i] + nums[i];
        }
        for (int j = 1; j < length; ++j) {
            for (int i = 0; i < j;  ++i) {
                int y = j + 1, x = i;
                int value = cache[y] - cache[x];
                if (k != 0 && value % k == 0) {
                    return true;
                } else if (k == 0 && value == 0) {
                    return true;
                }
            }
        }
        return false;
    }

}
