package leetcode.java.array;

import java.util.HashSet;
import java.util.Set;

public class P1119 {

	private final static Set<Character> set = new HashSet<Character>();
	static {
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
	}

	public String removeVowels(String S) {
		int length = S.length();
		StringBuffer buffer = new StringBuffer(length);
		for (int i = 0; i < length; ++i) {
			char c = S.charAt(i);
			if (!set.contains(c)) {
				buffer.append(c);
			}
		}
		return buffer.toString();
	}

}
