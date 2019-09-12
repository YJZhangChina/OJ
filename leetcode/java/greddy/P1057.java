package leetcode.java.greddy;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class P1057 {

	public int[] assignBikes(int[][] workers, int[][] bikes) {
		int m = workers.length, n = bikes.length;
		int[] ans = new int[m];
		Set<Integer> asignedWorkers = new HashSet<>(), asignedBikes = new HashSet<>();
		Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] == o2[2] ? o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0] : o1[2] - o2[2];
			}
		});
		for (int i = 0; i < m; ++i) {
			int[] worker = workers[i];
			for (int j = 0; j < n; ++j) {
				int[] bike = bikes[j];
				queue.add(new int[] { i, j, manhattanDistance(worker, bike) });
			}
		}
		while (!queue.isEmpty()) {
			int[] pair = queue.poll();
			int worker = pair[0], bike = pair[1];
			if (!asignedWorkers.contains(worker) && !asignedBikes.contains(bike)) {
				pair[worker] = bike;
				asignedWorkers.add(worker);
				asignedBikes.add(bike);
			}
		}
		return ans;
	}

	public int manhattanDistance(int[] worker, int[] bike) {
		return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
	}

}
