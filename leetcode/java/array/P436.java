package leetcode.java.array;

import java.util.Arrays;
import java.util.Comparator;

public class P436 {

	class P436Bean {
		int index;
		int from;
		int to;

		public P436Bean(int index, int from, int to) {
			this.index = index;
			this.from = from;
			this.to = to;
		}
	}

	public int[] findRightInterval(int[][] intervals) {
		int length = intervals.length;
		if (length == 0) {
			return new int[0];
		}
		if (length == 1) {
			return new int[] { -1 };
		}
		int[] ans = new int[length];
		Arrays.fill(ans, -1);
		P436Bean[] beans = new P436Bean[length];
		for (int i = 0; i < length; ++i) {
			beans[i] = new P436Bean(i, intervals[i][0], intervals[i][1]);
		}
		Arrays.sort(beans, new Comparator<P436Bean>() {
			@Override
			public int compare(P436Bean o1, P436Bean o2) {
				return o1.from == o2.from ? o1.to - o2.to : o1.from - o2.from;
			}
		});
		for (int i = 0; i < length; ++i) {
			P436Bean left = beans[i];
			for (int j = i + 1; j < length; ++j) {
				P436Bean right = beans[j];
				if (right.from >= left.to) {
					ans[left.index] = right.index;
					break;
				}
			}
		}
		return ans;
	}

}
