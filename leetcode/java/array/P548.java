package leetcode.java.array;

import java.util.HashSet;
import java.util.Set;

public class P548 {

	public boolean splitArray(int[] nums) {
		int length = nums.length;
		if (length < 7) {
			return false;
		}
		int[] sums = new int[length];
		sums[0] = nums[0];
		for (int i = 1; i < nums.length; ++i) {
			sums[i] = sums[i - 1] + nums[i];
		}
		for (int j = 3, o = length - 3; j < o; ++j) {
			Set<Integer> set = new HashSet<>();
			for (int i = 1, p = j - 1; i < p; ++i) {
				int left = sums[i - 1], right = sums[j - 1] - sums[i];
				if (left == right) {
					set.add(left);
				}
			}
			for (int k = j + 2, q = nums.length - 1; k < q; ++k) {
				int left = sums[k - 1] - sums[j], right = sums[length - 1] - sums[k];
				if (left == right && set.contains(left)) {
					return true;
				}
			}
		}
		return false;
	}

}
