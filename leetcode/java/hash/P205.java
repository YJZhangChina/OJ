package leetcode.java.hash;

import java.util.HashMap;
import java.util.Map;

public class P205 {

	public boolean isIsomorphic(String s, String t) {
		int l = s.length();
		Map<Character, Character> from = new HashMap<>();
		Map<Character, Character> to = new HashMap<>();
		for (int i = 0; i < l; ++i) {
			char m = s.charAt(i), n = t.charAt(i);
			if (!from.containsKey(m)) {
				from.put(m, n);
			} else {
				if (from.get(m) != n) {
					return false;
				}
			}
			if (!to.containsKey(n)) {
				to.put(n, m);
			} else {
				if (to.get(n) != m) {
					return false;
				}
			}
		}
		return true;
	}

}
