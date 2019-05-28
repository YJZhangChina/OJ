package leetcode.java.dp;

import leetcode.java.util.Util;

public class P523 {

    public static void main(String[] args) {
        P523 object = new P523();
        int[][] nums = new int[][]{
                {23, 2, 6, 4, 7}, // false
                {1, 0, 1, 0, 1},// false
                {0, 1, 0},// false
                {0, 0},// true
        };
        int[] k = new int[]{0, 4, 0, -1};
        int length = 4;
        for (int i = 0; i < length; ++i) {
            System.out.println(object.checkSubarraySum(nums[i], k[i]));
        }
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int length = nums.length;
        if (length < 2) {
            return false;
        }
        int[] cache = new int[length + 1];
        for (int i = 0; i < length; ++i) {
            cache[i + 1] = cache[i] + nums[i];
        }
        for (int j = 1; j < length; ++j) {
            for (int i = 0; i < j; ++i) {
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
