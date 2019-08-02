package leetcode.java.string;

public class P186 {

	public void reverseWords(char[] chars) {
		int length = chars.length, start = 0, end = length - 1;
		flip(chars, start, end);
		int last = 0;
		for (int i = 0; i < length; i++) {
			if (chars[i] == ' ') {
				flip(chars, last, i - 1);
				last = i + 1;
			}
		}
		flip(chars, last, length - 1);
		return;
	}

	public void flip(char[] chars, int start, int end) {
		while (start < end) {
			char c = chars[start];
			chars[start] = chars[end];
			chars[end] = c;
			start++;
			end--;
		}
	}

}
