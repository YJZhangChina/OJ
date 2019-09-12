package leetcode.java.hash;

import java.util.Collections;
import java.util.HashMap;

public class P159 {

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int n = s.length();
		if (n < 3) {
			return n;
		}
		int left = 0, right = 0, ans = 2;
		HashMap<Character, Integer> map = new HashMap<>();
		while (right < n) {
			if (map.size() < 3) {
				map.put(s.charAt(right), right++);
			}
			if (map.size() == 3) {
				int delete = Collections.min(map.values());
				map.remove(s.charAt(delete));
				left = delete + 1;
			}
			ans = Math.max(ans, right - left);
		}
		return ans;
	}

}
