package leetcode.java.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.java.util.TreeNode;

public class P366 {

	private Map<Integer, List<Integer>> map;

	public List<List<Integer>> findLeaves(TreeNode root) {
		map = new HashMap<>();
		search(root);
		List<Map.Entry<Integer, List<Integer>>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, List<Integer>>>() {
			@Override
			public int compare(Map.Entry<Integer, List<Integer>> o1, Map.Entry<Integer, List<Integer>> o2) {
				return o1.getKey() - o2.getKey();
			}
		});
		List<List<Integer>> ans = new ArrayList<>();
		for (Map.Entry<Integer, List<Integer>> entry : list) {
			ans.add(entry.getValue());
		}
		return ans;
	}

	public int search(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = search(node.left);
		int right = search(node.right);
		int value = Math.max(left, right) + 1;
		if (!map.containsKey(value)) {
			map.put(value, new ArrayList<>());
		}
		map.get(value).add(node.val);
		return Math.max(left, right) + 1;
	}

}
