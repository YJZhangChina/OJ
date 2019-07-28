package leetcode.java.hash;

import java.util.HashMap;
import java.util.Map;

public class P242 {

	public boolean isAnagram(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
		int lengthS = s.length(), lengthT = t.length();
		if (lengthS != lengthT) {
			return false;
		}
		for (int i = 0; i < lengthS; ++i) {
			char charS = s.charAt(i), charT = t.charAt(i);
			map.put(charS, map.getOrDefault(charS, 0) + 1);
			map.put(charT, map.getOrDefault(charT, 0) - 1);
		}
		for (char key : map.keySet()) {
			if (map.get(key) != 0) {
				return false;
			}
		}
		return true;
	}

}
