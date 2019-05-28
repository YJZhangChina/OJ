package leetcode.java.array;

public class P509 {

    public int fib(int N) {
        if(N == 0) {
            return 0;
        }
        if(N == 1) {
            return 1;
        }
        int i = 0, j = 1, k = 0;
        while(N > 1) {
            k = i + j;
            i = j;
            j = k;
            --N;
        }
        return k;
    }

}
