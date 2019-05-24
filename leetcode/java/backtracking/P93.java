package leetcode.java.backtracking;

import java.util.ArrayList;
import java.util.List;

public class P93 {

	public List<String> restoreIpAddresses(String s) {
		List<String> ans = new ArrayList<>();
		if (s == null) {
			return ans;
		}
		backtracking(0, s.length(), s, new ArrayList<>(), ans);
		return ans;
	}

	public void backtracking(int start, int length, String ip, List<Integer> track, List<String> ans) {
		if (start == length && track.size() == 4) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(track.get(0));
			for (int i = 1; i < 4; ++i) {
				buffer.append('.');
				buffer.append(track.get(i));
			}
			ans.add(buffer.toString());
		}
		if (start < ip.length() && track.size() < 4) {
			for (int i = 0; i < 3; i++) {
				int end = start + i + 1;
				if (end <= length) {
					Integer value = Integer.valueOf(ip.substring(start, end));
					if ((end - start == 2 && value < 10) || (end - start == 3 && value < 100)) {
						continue;
					}
					if (value >= 0 && value <= 255) {
						List<Integer> newTrack = new ArrayList<Integer>();
						newTrack.addAll(track);
						newTrack.add(value);
						backtracking(end, length, ip, newTrack, ans);
					}
				}
			}
		}
	}

}
