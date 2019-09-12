package leetcode.java.dp;

import leetcode.java.util.Util;

public class P1049 {

    public static void main(String[] args) {
        System.out.println(new P1049().lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(new P1049().lastStoneWeightII(new int[]{3, 2, 1, 7, 3, 7}));
    }

    public int lastStoneWeightII(int[] stones) {
        int l = stones.length;
        int[][] status = new int[l][l];
        status[0] = stones;
        for (int j = 0, n = l - 1; j < n; ++j) {
            status[1][j] = Math.abs(status[0][j] - status[0][j + 1]);
        }
        for (int i = 2; i < l; ++i) {
            for (int j = 0, n = l - i; j < n; ++j) {
                status[i][j] = Math.min(Math.abs(status[i - 1][j] - stones[j + i]), Math.abs(status[i - 1][j + 1] - stones[j]));
            }
        }
        Util.print(status);
        return status[l - 1][0];
    }

}
