package problems.random;

/* Swap two numbers without third */

class SwapNumbersWithoutThird {

  private static void swap(int a, int b) {
    a = a - b;
    b = a + b;
    a = b - a;

    System.out.println("a: " + a);
    System.out.println("b: " + b);
  }

  private static void swap_opt(int a, int b) {
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;

    System.out.println("a: " + a);
    System.out.println("b: " + b);
  }

  public static void main(String[] args) {
    int a = 1672;
    int b = 9332;

    System.out.println("a: " + a);
    System.out.println("b: " + b);

    swap(a, b);
    swap_opt(a, b);
  }
}
