package leetcode.java.util;

import java.util.List;

public class NArrayNode {
	public int val;
	public List<NArrayNode> children;

	public NArrayNode() {
	}

	public NArrayNode(int _val, List<NArrayNode> _children) {
		val = _val;
		children = _children;
	}
}
