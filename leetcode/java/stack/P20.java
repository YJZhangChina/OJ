package leetcode.java.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class P20 {

	public static final char[][] chars = { { '(', ')' }, { '[', ']' }, { '{', '}' }, };
	public static final Map<Character, Character> mapToFrom;
	public static final Set<Character> setFrom;
	public static final Set<Character> setTo;
	static {
		mapToFrom = new HashMap<>(4);
		setFrom = new HashSet<>(4);
		setTo = new HashSet<>(4);
		for (int i = 0, j = chars.length; i < j; i++) {
			mapToFrom.put(chars[i][1], chars[i][0]);
			setFrom.add(chars[i][0]);
			setTo.add(chars[i][1]);
		}
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0, j = s.length(); i < j; ++i) {
			char c = s.charAt(i);
			if (setFrom.contains(c)) {
				stack.push(c);
			} else if (setTo.contains(c)) {
				if (stack.isEmpty()) {
					return false;
				} else {
					if (mapToFrom.get(c) == stack.peek()) {
						stack.pop();
					} else {
						return false;
					}
				}
			} else {
				return false;
			}
		}
		return stack.isEmpty();
	}

}
