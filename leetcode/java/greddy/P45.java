package leetcode.java.greddy;

public class P45 {

	public int jump(int[] nums) {
		int step = 0, next = 0, end = 0;
		for (int i = 0, j = nums.length - 1; i < j; ++i) {
			next = i + nums[i] > next ? i + nums[i] : next;
			if (i == end) {
				++step;
				end = next;
			}
		}
		return step;
	}

}
