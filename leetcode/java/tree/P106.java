package leetcode.java.tree;

import java.util.Arrays;

import leetcode.java.util.TreeNode;

public class P106 {

	// needs improvement: do not use array copy
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int length = inorder.length;
		if (length == 0) {
			return null;
		}
		int value = postorder[length - 1];
		TreeNode root = new TreeNode(value);
		int index = -1;
		for (int i = 0; i < length; ++i) {
			if (inorder[i] == value) {
				index = i;
				break;
			}
		}
		int left = index, right = length - index - 1;
		if (left > 0) {
			root.left = buildTree(Arrays.copyOfRange(inorder, 0, left), Arrays.copyOfRange(postorder, 0, left));
		}
		if (right > 0) {
			root.right = buildTree(Arrays.copyOfRange(inorder, 1 + left, 1 + left + right),
					Arrays.copyOfRange(postorder, left, left + right));
		}
		return root;
	}

}
