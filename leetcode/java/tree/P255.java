package leetcode.java.tree;

import java.util.Stack;

public class P255 {

	public boolean verifyPreorder(int[] preorder) {
		int length = preorder.length;
		if (length < 2) {
			return true;
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(preorder[0]);
		int checker = Integer.MIN_VALUE;
		for (int i = 1; i < length; ++i) {
			int val = preorder[i];
			if (val < checker) {
				return false;
			} else {
				if (val < stack.peek()) {
					stack.push(val);
				} else {
					while (!stack.isEmpty() && stack.peek() < val) {
						checker = stack.pop();
					}
					stack.push(val);
				}
			}
		}
		return true;
	}

}
