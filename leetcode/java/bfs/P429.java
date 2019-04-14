package leetcode.java.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leecode.java.util.NArrayNode;

public class P429 {

	// Change NArrayNode to Node
	public List<List<Integer>> levelOrder(NArrayNode root) {
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		if (root != null) {
			Queue<NArrayNode> queue = new LinkedList<NArrayNode>();
			queue.add(root);
			while (!queue.isEmpty()) {
				int length = queue.size();
				List<Integer> list = new LinkedList<Integer>();
				for (int i = 0; i < length; i++) {
					NArrayNode node = queue.poll();
					list.add(node.val);
					for (NArrayNode child : node.children) {
						if (child != null) {
							queue.add(child);
						}
					}
				}
				ans.add(list);
			}
		}
		return ans;
	}

}
