package leetcode.java.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P354 {

    public int maxEnvelopes(int[][] envelopes) {
        int length = envelopes.length;
        if (length < 2) {
            return length;
        }
        List<int[]> list = new ArrayList<>();
        Collections.addAll(list, envelopes);
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        int ans = Integer.MIN_VALUE;
        int[] status = new int[length];
        for (int i = 0; i < length; ++i) {
            status[i] = 1;
            for (int j = 0; j < i; ++j) {
                boolean flag = list.get(i)[0] >= list.get(j)[0] && list.get(i)[1] > list.get(j)[1];
                status[i] = Math.max(flag ? status[j] + 1 : status[i], status[i]);
            }
            ans = Math.max(ans, status[i]);
        }
        return ans;
    }

}
