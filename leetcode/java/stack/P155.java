package leetcode.java.stack;

import java.util.Stack;

public class P155 {

	private Stack<Integer> integers, mins;

	// Change 'P155' to 'MinStack'
	/** initialize your data structure here. */
	public P155() {
		integers = new Stack<>();
		mins = new Stack<>();
	}

	public void push(int x) {
		integers.push(x);
		if (mins.isEmpty()) {
			mins.push(x);
		} else {
			mins.push(Math.min(x, mins.peek()));
		}
	}

	public void pop() {
		if (!integers.isEmpty()) {
			integers.pop();
			mins.pop();
		}
	}

	public int top() {
		return integers.peek();
	}

	public int getMin() {
		return mins.peek();
	}

}
