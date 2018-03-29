package problems.stacks;

/* Sort a given stack */

import java.util.Stack;

public class SortingAStack {

	static Stack sortStack(Stack<Integer> s) {

		// If stack is not empty
		if (!s.isEmpty()) {
			// Remove the top item
			int x = s.pop();

			// Sort remaining stack
			sortStack(s);

			// Push the top item back in sorted stack
			sortedInsert(s, x);
		}
		return s;
	}

	static void sortedInsert(Stack<Integer> s, int x) {
		// Base case: Either stack is empty or newly inserted
		// item is greater than top (more than all existing)
		if (s.isEmpty() || x > s.peek()) {
			s.push(x);
			return;
		}

		// If top is greater, remove the top item and recur
		int temp = s.pop();
		sortedInsert(s, x);

		// Put back the top item removed earlier
		s.push(temp);
	}

	public static void main(String args[]) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);

		System.out.println(stack.toString());
		Stack sorted = sortStack(stack);

		System.out.println(sorted.toString());
	}

}
