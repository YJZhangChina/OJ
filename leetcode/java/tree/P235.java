package leetcode.java.tree;

import leetcode.java.util.TreeNode;

public class P235 {

	public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
		int valNode = node.val, valP = p.val, valQ = q.val;
		if (valP > valNode && valQ > valNode) {
			return lowestCommonAncestor(node.right, p, q);
		} else if (valP < valNode && valQ < valNode) {
			return lowestCommonAncestor(node.left, p, q);
		} else {
			return node;
		}
	}

}
