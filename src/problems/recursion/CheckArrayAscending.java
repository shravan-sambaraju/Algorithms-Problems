package problems.recursion;

/*
 * Given an array of integers, write a recursive function to check whether the array is sorted in
 * ascending order.
 */
class CheckArrayAscending {

  private static boolean checkAscending(int[] A, int indexofA) {
    if (A.length == 1 || indexofA < 2) {
      return true;
    }
    return (A[indexofA - 1] < A[indexofA - 2]) ? false : checkAscending(A, indexofA - 1);
  }

  public static void main(String args[]) {
    int[] A = {1, 2, 3};
    System.out.println(checkAscending(A, A.length));
  }
}
