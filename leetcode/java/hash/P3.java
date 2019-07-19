package leetcode.java.hash;

import java.util.HashMap;
import java.util.Map;

public class P3 {

	public static void main(String[] args) {
		System.out.println(new P3().lengthOfLongestSubstring("abcabcbb")); // 3
		System.out.println(new P3().lengthOfLongestSubstring("bbbbb")); // 1
		System.out.println(new P3().lengthOfLongestSubstring("pwwkew")); // 3
		System.out.println(new P3().lengthOfLongestSubstring("au")); // 2
		System.out.println(new P3().lengthOfLongestSubstring("dvdf")); // 3
	}

	public int lengthOfLongestSubstring(String s) {
		int length = s.length();
		if (length < 2) {
			return length;
		}
		int index = 0, ans = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < length; ++i) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, i);
			} else {
				if (map.get(c) >= index) {
					ans = Math.max(ans, i - index);
					index = map.get(c) + 1;
				}
				map.put(c, i);
			}
		}
		ans = Math.max(ans, length - index);
		return ans;
	}

}
