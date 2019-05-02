package leetcode.java.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class P939 {

	public static void main(String[] args) {
		int[][] points = { { 1, 2 }, { 3, 2 }, { 1, 3 }, { 3, 3 }, { 3, 0 }, { 1, 4 }, { 4, 2 }, { 4, 0 } };
		new P939().minAreaRect(points);
	}

	public int minAreaRect(int[][] points) {
		int ans = Integer.MAX_VALUE;
		Map<Integer, Set<Integer>> map = new TreeMap<Integer, Set<Integer>>();
		for (int i = 0, j = points.length; i < j; ++i) {
			int[] pair = points[i];
			int x = pair[0], y = pair[1];
			if (map.containsKey(x)) {
				Set<Integer> set = map.get(x);
				set.add(y);
			} else {
				Set<Integer> set = new HashSet<Integer>();
				set.add(y);
				map.put(x, set);
			}
		}
		List<Map.Entry<Integer, Set<Integer>>> list = new ArrayList<Map.Entry<Integer, Set<Integer>>>(map.entrySet());
		int length = list.size();
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				System.out.println(i + " " + j);
				System.out.println(new ArrayList<Integer>(list.get(i).getValue()));
				System.out.println(new ArrayList<Integer>(list.get(j).getValue()));
				Set<Integer> overlap = new HashSet<Integer>(list.get(i).getValue());
				overlap.retainAll(list.get(j).getValue());
				int size = overlap.size();
				if (size <= 1) {
					continue;
				}
				List<Integer> integers = new ArrayList<Integer>(overlap);
				Collections.sort(integers);
				int width = Integer.MAX_VALUE;
				int height = list.get(j).getKey() - list.get(i).getKey();
				for (int m = 0, n = integers.size() - 1; m < n; m++) {
					width = Math.min(width, integers.get(m + 1) - integers.get(m));
					System.out.println(width);
					ans = Math.min(ans, width * height);
				}
			}
		}
		return ans != Integer.MAX_VALUE ? ans : 0;
	}

}
