package problems.queues;

/* Implement queue using two stacks */

import java.util.Stack;

public class QueueWithTwoStacks<T> {
	private Stack<T> S1 = new Stack<T>();
	private Stack<T> S2 = new Stack<T>();

	public void enqueue(T data) {
		S1.push(data);
	}

	public T dequeue() {
		if (S2.empty()) {
			while (!S1.isEmpty()) {
				S2.push(S1.pop());
			}

		}

		return S2.pop();
	}
}