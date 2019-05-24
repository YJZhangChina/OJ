package leetcode.java.dp;

public class P91 {

	public static void main(String[] args) {
		System.out.println(new P91().numDecodings("12")); // 2
		System.out.println(new P91().numDecodings("226")); // 3
		System.out.println(new P91().numDecodings("27"));// 1
		System.out.println(new P91().numDecodings("10"));// 1
		System.out.println(new P91().numDecodings("0"));// 0
		System.out.println(new P91().numDecodings("01"));// 0
		System.out.println(new P91().numDecodings(
				"1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"));
	}

	public int numDecodings(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		int length = s.length();
		int[] nums = new int[length];
		for (int i = 0; i < length; ++i) {
			nums[i] = Integer.valueOf(s.charAt(i) - '0');
		}
		int[][] status = new int[2][length];
		int value = nums[0];
		status[0][0] = (value > 0 && value < 10) ? 1 : 0;
		if (length > 1) {
			value = nums[1];
			status[0][1] = (value > 0 && value < 10) ? status[0][0] : 0;
			value = nums[0] * 10 + nums[1];
			status[1][1] = (value > 9 && value < 27) ? 1 : 0;
		}
		for (int i = 2; i < length; ++i) {
			value = nums[i];
			status[0][i] = (value > 0 && value < 10) ? status[0][i - 1] + status[1][i - 1] : 0;
			value = nums[i - 1] * 10 + nums[i];
			status[1][i] = (value > 9 && value < 27) ? status[0][i - 2] + status[1][i - 2] : 0;
		}
		return status[0][length - 1] + status[1][length - 1];
	}

//	public int numDecodings(String s) {
//		if (s == null) {
//			return 0;
//		}
//		return backtracking(0, s.length(), s);
//	}

//	public int backtracking(int start, int length, String code) {
//		if (start < length) {
//			int ans = 0;
//			for (int i = 0; i < 2; i++) {
//				int end = start + i + 1;
//				if (end <= length) {
//					Integer value = Integer.valueOf(code.substring(start, end));
//					if (end - start == 2 && value < 10) {
//						continue;
//					}
//					if (value > 0 && value < 27) {
//						if (end == length) {
//							ans += 1;
//						} else {
//							ans += backtracking(end, length, code);
//						}
//					}
//				}
//			}
//			return ans;
//		} else {
//			return 0;
//		}
//	}

}
