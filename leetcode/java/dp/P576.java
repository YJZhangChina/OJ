package leetcode.java.dp;

public class P576 {
	
	// TODO: needs improvements
	final int[][] movs = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    
	public int findPaths(int m, int n, int N, int p, int q) {
        if(N < 1) return 0;
        long[][][] status = new long[m][n][N];
        for(int k = 0; k < N; k++) {
            for(int i = 0; i < m; i++) { status[i][0][k] += 1; status[i][n - 1][k] += 1; }
            for(int i = 0; i < n; i++) { status[0][i][k] += 1; status[m - 1][i][k] += 1; }
        }

        for(int k = 1; k < N; k++) {
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    for(int l = 0; l < movs.length; l++) {
                        int x = i + movs[l][0];
                        int y = j + movs[l][1];
                        if(x >= 0 && x < m && y >= 0 && y < n) {
                            status[i][j][k] += (status[x][y][k - 1] % 1000000007);
                        }
                    }
                }
            }
        }
        return Long.valueOf(status[p][q][N - 1] % 1000000007).intValue();
    }

}
