package leetcode.java.dp;

public class P303 {

    int[] cache;

    // Change 'P303' to 'NumArray'
    public P303(int[] nums) {
        int length = nums.length;
        cache = new int[length + 1];
        for (int i = 0; i < length; ++i) {
            cache[i + 1] = cache[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return cache[j + 1] - cache[i];
    }

}
