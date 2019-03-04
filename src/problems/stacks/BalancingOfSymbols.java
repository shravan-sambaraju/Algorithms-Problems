package problems.stacks;

/* Balance brackets */

import java.util.Stack;

class BalancingOfSymbols {

    private static boolean isValidExpression(String s) {
        Stack<Character> stk = new Stack<Character>();
        if (s == null || s.length() == 0) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                if (!(stk.empty()) && stk.peek() == '[') {
                    stk.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if (!(stk.empty()) && stk.peek() == '{') {
                    stk.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == ')') {
                if (!(stk.empty()) && stk.peek() == '(') {
                    stk.pop();
                } else {
                    return false;
                }
            } else {
                if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                    stk.push(s.charAt(i));
                }
            }
        }
        if (stk.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        String s = "({[A]})";
        boolean check = isValidExpression(s);
        System.out.println(check);
    }
}
