package leetcode.java.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class P347 {

	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		Queue<int[]> queue = new PriorityQueue<>(k + 1, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			queue.offer(new int[] { entry.getKey(), entry.getValue() });
			if (queue.size() > k) {
				queue.poll();
			}
		}
		List<Integer> list = new ArrayList<>(k);
		while (!queue.isEmpty()) {
			list.add(queue.poll()[0]);
		}
		Collections.reverse(list);
		return list;
	}

}
