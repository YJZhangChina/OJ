package leetcode.java.string;

public class P58 {

	public int lengthOfLastWord(String s) {
		int ans = 0, length = s.length();
		boolean last = false;
		for (int i = length - 1; i >= 0; --i) {
			if (s.charAt(i) != ' ') {
				ans += 1;
				last = true;
			} else {
				if (last) {
					return ans;
				}
			}
		}
		return ans;
	}

}
