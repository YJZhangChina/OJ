package leetcode.java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P350 {

	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0) {
			return new int[0];
		}
		List<Integer> list = new ArrayList<Integer>(Math.max(nums1.length, nums2.length));
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0, j = 0, m = nums1.length, n = nums2.length;
		while (i < m && j < n) {
			if (nums1[i] > nums2[j]) {
				++j;
			} else if (nums1[i] < nums2[j]) {
				++i;
			} else {
				list.add(nums1[i]);
				++i;
				++j;
			}
		}
		int[] ans = new int[list.size()];
		for (int p = 0, q = list.size(); p < q; ++p) {
			ans[p] = list.get(p);
		}
		return ans;
	}

}
