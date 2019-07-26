package leetcode.java.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import leetcode.java.util.TreeNode;

public class P1110 {

	public List<TreeNode> delNodes(TreeNode root, int[] deletes) {
		List<TreeNode> forest = new ArrayList<>();
		Queue<TreeNode> remain = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		for (int delete : deletes) {
			set.add(delete);
		}
		remain.add(root);
		while (!remain.isEmpty()) {
			delete(forest, remain, set);
		}
		return forest;
	}

	public void delete(List<TreeNode> forest, Queue<TreeNode> remain, Set<Integer> deletes) {
		int size = remain.size();
		for (int i = 0; i < size; ++i) {
			TreeNode root = remain.poll();
			if (deletes.contains(root.val)) {
				if (root.left != null) {
					remain.add(root.left);
					root.left = null;
				}
				if (root.right != null) {
					remain.add(root.right);
					root.right = null;
				}
			} else {
				List<TreeNode> list = new ArrayList<>();
				forest.add(root);
				dfs(root, deletes, list);
				remain.addAll(list);
			}
		}
	}

	public void dfs(TreeNode root, Set<Integer> deletes, List<TreeNode> list) {
		TreeNode left = root.left, right = root.right;
		if (left != null) {
			if (deletes.contains(left.val)) {
				if (left.left != null) {
					list.add(left.left);
					left.left = null;
				}
				if (left.right != null) {
					list.add(left.right);
					left.right = null;
				}
				root.left = null;
			} else {
				dfs(left, deletes, list);
			}
		}
		if (right != null) {
			if (deletes.contains(right.val)) {
				if (right.left != null) {
					list.add(right.left);
					right.left = null;
				}
				if (right.right != null) {
					list.add(right.right);
					right.right = null;
				}
				root.right = null;
			} else {
				dfs(right, deletes, list);
			}
		}
	}

}
