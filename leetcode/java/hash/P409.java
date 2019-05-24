package leetcode.java.hash;

import java.util.HashMap;
import java.util.Map;

public class P409 {

	public int longestPalindrome(String s) {
		int ans = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0, j = s.length(); i < j; i++) {
			Character character = s.charAt(i);
			map.put(character, map.getOrDefault(character, 0) + 1);
		}
		boolean flag = false;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			int value = entry.getValue();
			if (value % 2 == 0) {
				ans += value;
			} else {
				if (!flag) {
					ans += value;
					flag = true;
				} else if (value > 1) {
					ans += (value - 1);
				}
			}
		}
		return ans;
	}

}
