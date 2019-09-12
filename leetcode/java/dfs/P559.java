package leetcode.java.dfs;

import leetcode.java.util.NArrayNode;

public class P559 {

	// Change type NarrayNode to Node
	public int maxDepth(NArrayNode root) {
		if (root == null) {
			return 0;
		}
		if (root.children == null || root.children.size() == 0) {
			return 1;
		}
		int ans = 0;
		for (int i = 0; i < root.children.size(); i++) {
			ans = Math.max(ans, 1 + maxDepth(root.children.get(i)));
		}
		return ans;
	}

}
