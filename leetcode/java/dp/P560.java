package leetcode.java.dp;

public class P560 {

    public int subarraySum(int[] nums, int k) {
        int count = 0, length = nums.length;
        for (int i = 0; i < length; ++i) {
            int sum = 0;
            for (int j = i; j < length; ++j) {
                sum += nums[j];
                if (sum == k) {
                    count += 1;
                }
            }
        }
        return count;
    }

}
