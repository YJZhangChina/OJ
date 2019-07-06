package leetcode.java.array;

public class P485 {

    public int findMaxConsecutiveOnes(int[] nums) {
		int index = 0, length = nums.length, current = 0, ans = 0;
		while (index < length) {
			if (nums[index] == 1) {
				current += 1;
			} else {
				ans = Math.max(ans, current);
				current = 0;
			}
			++index;
		}
		return Math.max(ans, current);
	}

}
