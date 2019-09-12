package leetcode.java.dp;

import java.util.Arrays;
import java.util.Comparator;

public class P354 {

	public int maxEnvelopes(int[][] envelopes) {
		Arrays.sort(envelopes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
			}
		});
		int length = envelopes.length, max = 0;
		int status[] = new int[length];
		Arrays.fill(status, 1);
		for (int i = 0; i < length; ++i) {
			for (int j = 0; j < i; ++j) {
				if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
					status[i] = Math.max(status[i], status[j] + 1);
				}
			}
			max = Math.max(max, status[i]);
		}
		return max;
	}

}
