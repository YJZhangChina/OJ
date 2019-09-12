package leetcode.java.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P49 {

	public List<List<String>> groupAnagrams(String[] strings) {
		List<List<String>> results = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for(String string : strings) {
			char[] chars = string.toCharArray();
			Arrays.sort(chars);
			String key = new String(chars);
			if(!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(string);
		}
		for(Map.Entry<String, List<String>> entry : map.entrySet()) {
			results.add(entry.getValue());
		}
		return results;
	}

}
