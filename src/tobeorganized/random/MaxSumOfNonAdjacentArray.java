package tobeorganized.random;

class MaxSumOfNonAdjacentArray {

  private static int calculateSum(int array[], int n) {
    int incl = array[0];
    int excl = 0;
    int excl_new;

    for (int i = 1; i < n; i++) {
      excl_new = (incl > excl) ? incl : excl;
      incl = excl + array[i];
      excl = excl_new;
    }

    return (incl > excl ? incl : excl);
  }

  public static void main(String[] args) {
    MaxSumOfNonAdjacentArray sum = new MaxSumOfNonAdjacentArray();
    int arr[] = new int[] {5, 5, 10, 100, 10, 5};
    System.out.println(sum.calculateSum(arr, arr.length));
  }
}
