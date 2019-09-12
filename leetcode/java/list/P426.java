package leetcode.java.list;

import leetcode.java.util.TreeNode;

public class P426 {

	private TreeNode start = null, end = null;

	public void search(TreeNode node) {
		if (node != null) {
			// left
			search(node.left);
			// node
			if (end != null) {
				// link the previous node (last)
				// with the current one (node)
				end.right = node;
				node.left = end;
			} else {
				// keep the smallest node
				// to close DLL later on
				start = node;
			}
			end = node;
			// right
			search(node.right);
		}
	}

	public TreeNode treeToDoublyList(TreeNode root) {
		if (root == null) {
			return root;
		}
		search(root);
		end.right = start;
		start.left = end;
		return start;
	}

}
