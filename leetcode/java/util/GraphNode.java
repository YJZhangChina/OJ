package leetcode.java.util;

import java.util.List;

public class GraphNode {

	public int val;
	public List<GraphNode> neighbors;

	public GraphNode() {
	}

	public GraphNode(int _val, List<GraphNode> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}

}
