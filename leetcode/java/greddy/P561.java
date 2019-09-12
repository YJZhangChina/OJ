package leetcode.java.greddy;

import java.util.Arrays;

public class P561 {

	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int length = (int) nums.length / 2, ans = 0;
		for (int i = 0; i < length; ++i) {
			ans += nums[i * 2];
		}
		return ans;
	}

}
