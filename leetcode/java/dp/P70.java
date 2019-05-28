package leetcode.java.dp;

public class P70 {

    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        int[] status = new int[n];
        status[0] = 1;
        status[1] = 2;
        for(int i = 2; i < n; ++i) {
            status[i] = status[i - 2] + status[i - 1];
        }
        return status[n - 1];
    }

}
