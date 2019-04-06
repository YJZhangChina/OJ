package leetcode.java.dfs;

import leecode.java.util.TreeNodeNext;

public class P116 {

	// Change the type NarrayNode to Node
	public TreeNodeNext connect(TreeNodeNext root) {
		if(root != null && root.left != null && root.right != null) {
			iterating(root.left, root.right);
		}
		return root;
	}
	
	// Change the type NarrayNode to Node
	public void iterating(TreeNodeNext left, TreeNodeNext right) {
		if(left != null && right != null) {
			left.next = right;
			iterating(left.left, left.right);
			iterating(left.right, right.left);
			iterating(right.left, right.right);
		}
	}
}
