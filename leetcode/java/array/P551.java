package leetcode.java.array;

public class P551 {

	public static void main(String[] args) {
		System.out.println(new P551().checkRecord("LALL"));
	}

	public boolean checkRecord(String s) {
		int index = 0, length = s.length(), a = 0, b = 0;
		while (index < length) {
			char c = s.charAt(index);
			if (c == 'L') {
				if (b == 2) {
					return false;
				} else {
					++b;
				}
			} else {
				if (c == 'A') {
					if (a == 1) {
						return false;
					} else {
						++a;
					}
				}
				b = 0;
			}
			++index;
		}
		return true;
	}

}
