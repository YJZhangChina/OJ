package leetcode.java.recursion;

import java.util.LinkedList;
import java.util.List;

import leecode.java.util.NArrayNode;

public class P590 {

	// Change NArrayNode to Node
	public List<Integer> postorder(NArrayNode root) {
		List<Integer> ans = new LinkedList<Integer>();
		recursion(root, ans);
		return ans;
	}

	// Change NArrayNode to Node
	public void recursion(NArrayNode parent, List<Integer> ans) {
		if (parent != null) {
			for (NArrayNode child : parent.children) {
				recursion(child, ans);
			}
		}
		ans.add(parent.val);
	}

}
