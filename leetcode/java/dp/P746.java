package leetcode.java.dp;

import leetcode.java.util.Util;

public class P746 {

        public int minCostClimbingStairs(int[] cost) {
            int length = cost.length;
            if (length == 2) {
                return Math.min(cost[0], cost[1]);
            }
            int[] status = new int[length];
            status[0] = cost[0];
            status[1] = cost[1];
            for (int i = 2; i < length; ++i) {
                status[i] = cost[i] + Math.min(status[i - 2], status[i - 1]);
            }
            return Math.min(status[length - 2], status[length - 1]);
        }

}
