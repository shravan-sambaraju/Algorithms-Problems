package problems.stacks;

/* Calculate maximum area of histogram */

import java.util.Stack;

public class MaxRectangleAreaOfHistogram {
	public int MaxRectangleArea(int[] A) {
		Stack<Integer> s = new Stack<Integer>();
		if (A == null || A.length == 0)
			return 0;
		// Initialize max area
		int maxArea = 0;
		int i = 0;
		// run through all bars of given histogram
		while (i < A.length) {
			// If current bar is higher than the bar of the stack peek, push it
			// to stack.
			if (s.empty() || A[s.peek()] <= A[i])
				s.push(i++);
			else {
				// if current bar is lower than the stack peek, calculate area
				// of rectangle with stack top as the smallest bar.
				// 'i' is 'right index' for the top and element before top in
				// stack is 'left index'
				int top = s.pop();
				// calculate the area with A[top] stack as smallest bar and
				// update maxArea if needed
				maxArea = Math.max(maxArea, A[top] * (s.empty() ? i : i - s.peek() - 1));
			}
		}
		// Now pop the remaining bars from stack and calculate area with every
		// popped bar as the smallest bar.
		while (!s.isEmpty()) {
			int top = s.pop();
			maxArea = Math.max(maxArea, A[top] * (s.empty() ? i : i - s.peek() - 1));
		}
		return maxArea;
	}

	public static void main(String args[]) {

		MaxRectangleAreaOfHistogram maxArea = new MaxRectangleAreaOfHistogram();
		int[] a = { 1, 2, 3, 4, 5, 6 };
		int area = maxArea.MaxRectangleArea(a);
		System.out.println(area);
	}
}
