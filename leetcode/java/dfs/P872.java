package leetcode.java.dfs;

import java.util.ArrayList;
import java.util.List;

import leetcode.java.util.TreeNode;

public class P872 {

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 != null && root2 != null) {
			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();
			dfs(root1, list1);
			dfs(root2, list2);
			if (list1.size() != list2.size()) {
				return false;
			}
			for (int i = 0, j = list1.size(); i < j; ++i) {
				if (list1.get(i) != list2.get(i)) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public void dfs(TreeNode root, List<Integer> sequence) {
		if (root.left == null && root.right == null) {
			sequence.add(root.val);
		}
		if (root.left != null) {
			dfs(root.left, sequence);
		}
		if (root.right != null) {
			dfs(root.right, sequence);
		}
	}

}
