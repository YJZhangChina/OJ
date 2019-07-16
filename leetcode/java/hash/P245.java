package leetcode.java.hash;

public class P245 {

	public int shortestWordDistance(String[] words, String word1, String word2) {
		if (word1.equals(word2)) {
			return distanceSame(words, word1);
		} else {
			return distanceDifferent(words, word1, word2);
		}
	}

	public int distanceSame(String[] words, String word) {
		int previous = -1, ans = words.length;
		for (int i = 0, j = words.length; i < j; ++i) {
			if (words[i].equals(word)) {
				if (previous != -1) {
					ans = Math.min(ans, i - previous);
				}
				previous = i;
			}
		}
		return ans;
	}

	public int distanceDifferent(String[] words, String word1, String word2) {
		int index1 = -1, index2 = -1, ans = words.length;
		for (int i = 0, j = words.length; i < j; ++i) {
			if (words[i].equals(word1)) {
				index1 = i;
				if (index1 != -1 && index2 != -1) {
					ans = Math.min(ans, Math.abs(index1 - index2));
				}
			} else if (words[i].equals(word2)) {
				index2 = i;
				if (index1 != -1 && index2 != -1) {
					ans = Math.min(ans, Math.abs(index1 - index2));
				}
			}
		}
		return ans;
	}

}
