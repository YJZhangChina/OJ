package leetcode.java.bit;

public class P461 {

	public int hammingDistance(int x, int y) {
		int ans = 0;
		int bit = 1;
		for (int i = 0, j = 32 - 1; i < j; ++i) {
			if ((x & bit) != (y & bit)) {
				ans += 1;
			}
			bit <<= 1;
		}
		return ans;
	}

}
