package leetcode.java.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P973 {

	public int[][] kClosest(int[][] points, int K) {
		Queue<int[]> queue = new PriorityQueue<int[]>(K, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		for (int i = 0, j = points.length; i < j; ++i) {
			int[] point = points[i];
			queue.add(new int[] { point[0] * point[0] + point[1] * point[1], i });
		}
		int[][] ans = new int[K][2];
		for (int i = 0; i < K; ++i) {
			int[] pair = queue.poll();
			ans[i] = points[pair[1]];
		}
		return ans;
	}

}
