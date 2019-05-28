package leetcode.java.dp;

import java.util.*;

public class P646 {

    // TODO: needs improvements
    public int findLongestChain(int[][] pairs) {
        int length = pairs.length;
        if (length < 2) {
            return length;
        }
        List<int[]> list = new ArrayList<>();
        for (int[] pair : pairs) {
            list.add(pair);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        int[] status = new int[length];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < length; ++i) {
            status[i] = 1;
            for (int j = 0; j < i; ++j) {
                status[i] = Math.max(list.get(i)[0] > list.get(j)[1] ? status[j] + 1 : status[i], status[i]);
            }
            ans = Math.max(ans, status[i]);
        }
        return ans;
    }

}
