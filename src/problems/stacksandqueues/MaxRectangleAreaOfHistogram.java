package problems.stacksandqueues;

/* Calculate maximum area of histogram */
import java.util.Stack;

class MaxRectangleAreaOfHistogram {

  public static void main(String args[]) {
    MaxRectangleAreaOfHistogram maxArea = new MaxRectangleAreaOfHistogram();
    int[] a = {1, 2, 3, 4, 5, 6};
    int area = maxArea.MaxRectangleArea(a);
    System.out.println(area);
  }

  private int MaxRectangleArea(int[] A) {
    Stack<Integer> s = new Stack<Integer>();
    if (A == null || A.length == 0) {
      return 0;
    }
    int maxArea = 0;
    int i = 0;
    while (i < A.length) {
      if (s.empty() || A[s.peek()] <= A[i]) {
        s.push(i++);
      } else {
        int top = s.pop();
        maxArea = Math.max(maxArea, A[top] * (s.empty() ? i : i - s.peek() - 1));
      }
    }
    while (!s.isEmpty()) {
      int top = s.pop();
      maxArea = Math.max(maxArea, A[top] * (s.empty() ? i : i - s.peek() - 1));
    }
    return maxArea;
  }
}
