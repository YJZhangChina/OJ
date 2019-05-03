package leetcode.java.bit;

public class P477 {
	public int totalHammingDistance(int[] nums) {
		int ans = 0;
		int[] status = new int[32];
		for (int num : nums) {
			char[] chars = Integer.toBinaryString(num).toCharArray();
			int j = chars.length;
			for (int i = 0; i < j; ++i) {
				if (chars[i] == '1') {
					status[32 - j + i] += 1;
				}
			}
		}
		for (int i = 0; i < 32; i++) {
			ans += status[i] * (nums.length - status[i]);
		}
		return ans;
	}
}
