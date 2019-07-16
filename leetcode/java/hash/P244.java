package leetcode.java.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P244 {

	private Map<String, List<Integer>> map;

	// Change 'P244' to 'WordDistance'
	public P244(String[] words) {
		map = new HashMap<>();
		for (int i = 0, j = words.length; i < j; ++i) {
			String key = words[i];
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(i);
		}
	}

	public int shortest(String word1, String word2) {
		List<Integer> list1 = map.get(word1), list2 = map.get(word2);
		int length1 = list1.size(), length2 = list2.size(), index1 = 0, index2 = 0, min = Integer.MAX_VALUE;
		while (index1 < length1 && index2 < length2) {
			min = Math.min(min, Math.abs(list1.get(index1) - list2.get(index2)));
			if (list1.get(index1) < list2.get(index2)) {
				++index1;
			} else {
				++index2;
			}
		}
		return min;
	}

}
