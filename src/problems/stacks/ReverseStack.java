package problems.stacks;

import java.util.Stack;

public class ReverseStack {

	public static Stack reverse(Stack stack) {
		if (stack.isEmpty()) {
			return stack;
		}
		int temp = (int) stack.pop();
		reverse(stack);
		insertAtBottom(stack, temp);

		return stack;

	}

	public static void insertAtBottom(Stack stack, int data) {
		if (stack.isEmpty()) {
			stack.push(data);
			return;

		}
		int temp = (int) stack.pop();
		insertAtBottom(stack, data);
		stack.push(temp);

	}

	public static void main(String args[]) {

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);

		System.out.println(stack.toString());
		System.out.println(stack.peek());

		Stack reversed = reverse(stack);
		System.out.println(reversed.toString());
		System.out.println(reversed.peek());

	}

}
