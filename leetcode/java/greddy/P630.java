package leetcode.java.greddy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import leetcode.java.util.Util;

public class P630 {

	public static void main(String[] args) {
		new P630().scheduleCourse(new int[][] { { 5, 5 }, { 4, 6 }, { 2, 6 }, });
	}

	public int scheduleCourse(int[][] courses) {
		Arrays.sort(courses, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
			}
		});
		for (int[] course : courses) {
			Util.print(course);
		}
		Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		int time = 0;
		for (int[] course : courses) {
			if (time + course[0] <= course[1]) {
				queue.offer(course[0]);
				time += course[0];
			} else if (!queue.isEmpty() && queue.peek() > course[0]) {
				time += course[0] - queue.poll();
				queue.offer(course[0]);
			}
		}
		return queue.size();
	}

}
