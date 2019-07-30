package leetcode.java.array;

import java.util.List;

public class P624 {

	public int maxDistance(List<List<Integer>> arrays) {
		List<Integer> array = arrays.get(0);
		int ans = 0, min = array.get(0), max = array.get(array.size() - 1);
		for (int i = 1, j = arrays.size(); i < j; ++i) {
			array = arrays.get(i);
			int start = array.get(0), end = array.get(array.size() - 1);
			ans = Math.max(ans, Math.max(Math.abs(start - max), Math.abs(end - min)));
			min = Math.min(min, start);
			max = Math.max(max, end);
		}
		return ans;
	}

}
