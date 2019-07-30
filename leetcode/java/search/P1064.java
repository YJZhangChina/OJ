package leetcode.java.search;

public class P1064 {

    public int fixedPoint(int[] A) {
		int i = 0, j = A.length - 1;
		while (i < j) {
			int k = i + (j - i) / 2;
			if (k < A[k]) {
				j = k;
			} else if (k > A[k]) {
				i = k + 1;
			} else {
                break;
            }
		}
		return A[i] == i ? i : -1;
	}

}
