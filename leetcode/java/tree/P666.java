package leetcode.java.tree;

import java.util.HashMap;
import java.util.Map;

public class P666 {

	private int ans;
	private Map<Integer, Integer> map;

	public int pathSum(int[] nums) {
		map = new HashMap<>();
		for (int num : nums) {
			int key = num / 10, value = num % 10;
			map.put(key, value);
		}
		recursion(11, 0);
		return ans;
	}

	public void recursion(int node, int sum) {
		int key = node / 10, value = node % 10;
		int left = (key + 1) * 10 + value * 2 - 1, right = (key + 1) * 10 + value * 2;
		sum += map.get(node);
		if (!map.containsKey(left) && !map.containsKey(right)) {
			ans += sum;
			return;
		}
		if (map.containsKey(left)) {
			recursion(left, sum);
		}
		if (map.containsKey(right)) {
			recursion(right, sum);
		}
	}

}
