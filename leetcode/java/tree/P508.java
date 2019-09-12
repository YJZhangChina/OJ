package leetcode.java.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.java.util.TreeNode;

public class P508 {

	private Map<Integer, Integer> map = new HashMap<>();

	public int[] findFrequentTreeSum(TreeNode root) {
		if (root != null) {
			map.clear();
			dfs(root);
			List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
				@Override
				public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
					return o1.getValue() == o2.getValue() ? o1.getKey() - o2.getKey() : o2.getValue() - o1.getValue();
				}
			});
			int frequency = list.get(0).getValue(), size = 0;
			for (Map.Entry<Integer, Integer> entry : list) {
				if (entry.getValue() == frequency) {
					++size;
				} else {
					break;
				}
			}
			int[] array = new int[size];
			for (int i = 0; i < size; ++i) {
				array[i] = list.get(i).getKey();
			}
			return array;
		} else {
			return new int[0];
		}
	}

	public int dfs(TreeNode node) {
		int value = node.val;
		if (node.left == null && node.right == null) {
            map.put(value, map.getOrDefault(value, 0) + 1);
			return value;
		}
		if (node.left != null) {
			value += dfs(node.left);
		}
		if (node.right != null) {
			value += dfs(node.right);
		}
		map.put(value, map.getOrDefault(value, 0) + 1);
		return value;
	}

}
