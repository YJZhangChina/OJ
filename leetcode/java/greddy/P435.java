package leetcode.java.greddy;

import java.util.Arrays;
import java.util.Comparator;

public class P435 {

	public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
			}
		});
		int length = intervals.length, ans = 0, index = 0;
		for (int i = 1; i < length; ++i) {
			if (intervals[i][0] < intervals[index][1]) {
				++ans;
				if (intervals[i][1] < intervals[index][1]) {
					index = i;
				}
			} else {
				index = i;
			}
		}
		return ans;
	}

}
