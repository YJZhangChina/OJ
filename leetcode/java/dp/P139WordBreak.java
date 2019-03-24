package leetcode.java.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P139WordBreak {
	
	public static void main(String[] args) {
		new P139WordBreak().wordBreak("leetcode", new ArrayList<String>());
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<String>(wordDict);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		return check(s, set, map);
	}

	public boolean check(String s, Set<String> dict, Map<String, Boolean> map) {
		if(map.containsKey(s)) { return map.get(s); }
		if(dict.contains(s)) { map.put(s, true); return true; }
		int j = s.length();
		for (int i = 1; i < j; i++) {
			String left = s.substring(0, i);
			String right = s.substring(i);
			if(dict.contains(right) && check(left, dict, map)) {
				map.put(s, true);
				return true;
			}
		}
		map.put(s, false);
		return false;
	}

}
