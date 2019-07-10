package leetcode.java.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P246 {

	private static final Map<Character, Character> map = new HashMap<>();
	private static final Set<Character> set = new HashSet<>();
	static {
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');
		set.add('0');
		set.add('1');
		set.add('8');
	}

	public boolean isStrobogrammatic(String num) {
		if (num == null || num.isEmpty()) {
			return false;
		}
		int i = 0, j = num.length() - 1, k = num.length();
		while (i < j) {
			char m = num.charAt(i), n = num.charAt(j);
			if (!map.containsKey(m) || map.get(m) != n) {
				return false;
			}
			++i;
			--j;
		}
		if (k % 2 != 0) {
			return set.contains(num.charAt((k - 1) / 2));
		}
		return true;
	}

}
