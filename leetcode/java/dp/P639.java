package leetcode.java.dp;

public class P639 {
	/**
	 * "*"	9
	 * "1*"	18
	 * "*********"	291868912
	 * "2*"	15
	 * "1*72*"	285
	 * "**********1111111111"	133236775
	 */

	private static final int MOD = 1000000007;

	public int numDecodings(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		int length = s.length();
		int[] nums = new int[length];
		long[] status = new long[length];
		for (int i = 0; i < length; ++i) {
			nums[i] = s.charAt(i) != '*' ? Integer.valueOf(s.charAt(i) - '0') : -1;
		}
		status[0] = checkSingle(nums, 0);
		if (status[0] == 0) {
			return 0;
		}
		if (length > 1) {
			status[1] += checkSingle(nums, 1) * status[0];
			status[1] += checkDouble(nums, 1);
		}
		for (int i = 2; i < length; ++i) {
			status[i] += ((checkSingle(nums, i) * status[i - 1]) % MOD);
			status[i] += ((checkDouble(nums, i) * status[i - 2]) % MOD);
		}
		return Long.valueOf(status[length - 1] % MOD).intValue();
	}

	public int checkSingle(int[] nums, int index) {
		int value = nums[index];
		return value == -1 ? 9 : value > 0 ? 1 : 0;
	}

	public int checkDouble(int[] nums, int index) {
		int value = nums[index - 1] * 10 + nums[index];
		if (value == -11) {
			return 15;
		} else if (nums[index - 1] == -1) {
			return nums[index] < 7 ? 2 : 1;
		} else if (nums[index] == -1) {
			return nums[index - 1] == 1 ? 9 : nums[index - 1] == 2 ? 6 : 0;
		} else {
			return (value > 9 && value < 27) ? 1 : 0;
		}
	}

}
