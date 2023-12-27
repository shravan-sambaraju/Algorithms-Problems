package problems.stacksandqueues;

/* Post fix evaluation using stack */
import java.util.Stack;

class PostFixEvaluation {

  private static int expressionEvaluation(String[] tokens) {
    Stack<Integer> s = new Stack<Integer>();
    for (String token : tokens) {
      if (token.equals("+")) {
        int op1 = s.pop();
        int op2 = s.pop();
        int res = op1 + op2;
        s.push(res);
      } else if (token.equals("-")) {
        int op1 = s.pop();
        int op2 = s.pop();
        int res = op2 - op1;
        s.push(res);
      } else if (token.equals("*")) {
        int op1 = s.pop();
        int op2 = s.pop();
        int res = op1 * op2;
        s.push(res);
      } else if (token.equals("/")) {
        int op1 = s.pop();
        int op2 = s.pop();
        int res = op2 / op1;
        s.push(res);
      } else {
        s.push(Integer.parseInt(token));
      }
    }
    return s.pop();
  }

  public static void main(String args[]) {
    String[] s = {"1", "2", "3", "*", "+", "5", "-"};
    int s1 = expressionEvaluation(s);
    System.out.println(s1);
  }
}
