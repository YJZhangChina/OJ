package leetcode.java.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P249 {

	public List<List<String>> groupStrings(String[] strings) {
		Map<String, List<String>> map = new HashMap<>();
		List<List<String>> results = new ArrayList<>();
		for (String string : strings) {
			char[] chars = new char[string.length()];
			for (int i = 0, j = chars.length; i < j; ++i) {
				chars[i] += (string.charAt(i) - string.charAt(0) + 26) % 26;
			}
			String key = new String(chars);
			if(!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
 			map.get(key).add(string);
		}
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			results.add(entry.getValue());
		}
		return results;
	}

}
