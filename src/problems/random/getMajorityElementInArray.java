package problems.random;

/** Get majority elements in array */
class getMajorityElementInArray {

  private static int getCandidate(int[] array) {
    int majority = 0;
    int count = 0;
    for (int n : array) {
      if (count == 0) {
        majority = n;
      }
      if (n == majority) {
        count++;
      } else {
        count--;
      }
    }
    return majority;
  }

  private static boolean validate(int[] array, int majority) {
    int count = 0;
    for (int n : array) {
      if (n == majority) {
        count++;
      }
    }
    return count > array.length / 2;
  }

  private static int findMajorityElement(int[] array) {
    int candidate = getCandidate(array);
    return validate(array, candidate) ? candidate : -1;
  }

  public static void main(String[] args) {
    int[] array = {0, 0, 1, 2, 2, 0, 1, 0, 1, 1, 1, 1, 1};
    System.out.println(array.length);
    System.out.println(findMajorityElement(array));
  }
}
