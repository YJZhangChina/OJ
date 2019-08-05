package leetcode.java.stack;

import java.util.Stack;

public class P232 {

	private Stack<Integer> from, to;
	private boolean flag;

	// Change 'P232' to 'MyQueue'
	/** Initialize your data structure here. */
	public P232() {
		from = new Stack<>();
		to = new Stack<>();
		flag = true;
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		if (!flag) {
			swap(to, from);
			flag = true;
		}
		from.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if(flag) {
			swap(from, to);
			flag = false;
		}
		return to.pop();
	}

	/** Get the front element. */
	public int peek() {
		if(flag) {
			swap(from, to);
			flag = false;
		}
		return to.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return flag ? from.isEmpty() : to.isEmpty();
	}

	public void swap(Stack<Integer> from, Stack<Integer> to) {
		while (!from.isEmpty()) {
			to.push(from.pop());
		}
	}

}
