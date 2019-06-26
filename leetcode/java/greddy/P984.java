package leetcode.java.greddy;

public class P984 {

	public String strWithout3a3b(int A, int B) {
		StringBuffer buffer = new StringBuffer(A + B);
		while (A > 0 || B > 0) {
			boolean writeA = false;
			int L = buffer.length();
			if (L >= 2 && buffer.charAt(L - 1) == buffer.charAt(L - 2)) {
				if (buffer.charAt(L - 1) == 'b') {
					writeA = true;
				}
			} else {
				if (A >= B) {
					writeA = true;
				}
			}
			if (writeA) {
				buffer.append('a');
				A--;
			} else {
				buffer.append('b');
				B--;
			}
		}
		return buffer.toString();
	}

}
