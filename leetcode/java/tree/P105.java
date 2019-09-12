package leetcode.java.tree;

import java.util.Arrays;

import leetcode.java.util.TreeNode;

public class P105 {

	// needs improvement: do not use array copy
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int length = preorder.length;
		if (length == 0) {
			return null;
		}
		int value = preorder[0];
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
			root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + left), Arrays.copyOfRange(inorder, 0, left));
		}
		if (right > 0) {
			root.right = buildTree(Arrays.copyOfRange(preorder, 1 + left, 1 + left + right),
					Arrays.copyOfRange(inorder, 1 + left, 1 + left + right));
		}
		return root;
	}

}
