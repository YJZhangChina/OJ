package leetcode.java.dp;


public class P712 {

    public int minimumDeleteSum(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) {
            return 0;
        }
        int m = s1.length(), n = s2.length();
        int[][] status = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i) {
            status[i + 1][0] = status[i][0] + s1.charAt(i);
        }
        for (int j = 0; j < n; ++j) {
            status[0][j + 1] = status[0][j] + s2.charAt(j);
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                status[i + 1][j + 1] = s1.charAt(i) == s2.charAt(j) ? status[i][j] : Math.min(status[i][j + 1] + s1.charAt(i), status[i + 1][j] + s2.charAt(j));
            }
        }
        return status[m][n];
    }

}
