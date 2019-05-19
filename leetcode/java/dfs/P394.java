package leetcode.java.dfs;

public class P394 {

	public static void main(String[] args) {
		System.out.println(0);
		System.out.println(0 ^ 1);
		System.out.println(1 ^ 1);
//		String string = new P394().decodeString("3[a]2[bc]");
//		System.out.println(string);
//		System.out.println('a' - '9');
	}

	public String decodeString(String s) {
		if (!s.contains("[")) {
			return s;
		} else {
			char[] chars = s.toCharArray();
			int start = -1, end = -1, flag = 0, prev = 0;
			boolean prefix = true;
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < chars.length; i++) {

				if (chars[i] == '[') {
					start = i;
					flag += 1;
				} else if (chars[i] == ']') {
					flag -= 1;
					if (flag == 0) {
						end = i;
						while (chars[prev] > '9' && prev < start) {
							prev++;
						}
						int time = Integer.valueOf(s.substring(prev, start));
						if (time == 0) {
							time = 1;
						}
						String subString = s.substring(start + 1, end);
						subString = decodeString(subString);
						for (int j = 0; j < time; j++) {
							buffer.append(subString);
						}
						prev = end + 1;
					}
				}
			}
			return buffer.toString();
		}
	}

}
