package leetcode.java.math;

public class P263 {

	public boolean isUgly(int num) {
		if (num == 0) {
			return false;
		}
		if (num == 1) {
			return true;
		}
		int[] ints = { 5, 3, 2 };
		for (int i = 0; i < ints.length; i++) {
			while (num % ints[i] == 0) {
				num = num / ints[i];
				if (num == 1) {
					return true;
				}
			}
		}
		return false;
	}

}
