package leetcode.java.dp;

public class P583 {

    public int minDistance(String word1, String word2) {
        if (word1.isEmpty()) {
            return word2.length();
        }
        if (word2.isEmpty()) {
            return word1.length();
        }
        int m = word1.length(), n = word2.length();
        int[][] status = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i) {
            status[i + 1][0] = i + 1;
        }
        for (int j = 0; j < n; ++j) {
            status[0][j + 1] = j + 1;
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                status[i + 1][j + 1] = word1.charAt(i) == word2.charAt(j) ? status[i][j] : 1 + Math.min(status[i + 1][j], status[i][j + 1]);
            }
        }
        return status[m][n];
    }

}
