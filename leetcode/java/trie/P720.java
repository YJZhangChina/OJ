package leetcode.java.trie;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class P720 {

	public String longestWord(String[] words) {
		int current = -1;
		String ans = null;
		Set<String> set = new HashSet<>();
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length();
			}
		});
		for (String word : words) {
			int length = word.length();
			if (length == 1 || set.contains(word.substring(0, length - 1))) {
				set.add(word);
			}
			if (length > current) {
				current = length;
				ans = word;
			}
		}
		return ans;
	}

}
