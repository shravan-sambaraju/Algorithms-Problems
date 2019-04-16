package tobeorganized.codingproblems;

class TrapRainWaterInArray {

  private static int trapWater(int[] array) {
    int n = array.length;
    int[] left = new int[n];
    int[] right = new int[n];
    int water = 0;

    left[0] = array[0];
    for (int i = 1; i < n; i++) {
      left[i] = Math.max(left[i - 1], array[i]);
    }
    right[n - 1] = array[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      right[i] = Math.max(right[i + 1], array[i]);
    }

    for (int i = 0; i < n; i++) {
      water += Math.min(left[i], right[i]) - array[i];
    }
    return water;
  }

  private static int trapWater2(int[] array) {

    int n = array.length;
    int left_max = 0, right_max = 0, result = 0;
    int lo = 0, hi = n - 1;
    int water = 0;

    while (lo < hi) {
      if (array[lo] < array[hi]) {
        if (array[lo] > left_max) {
          left_max = array[lo];
        } else {
          water += left_max - array[lo];
          lo++;
        }
      } else {
        if (array[hi] > right_max) {
          right_max = array[hi];
        } else {
          water += right_max - array[hi];
          hi--;
        }
      }
    }
    return water;
  }

  public static void main(String[] args) {
    int arr[] = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(trapWater(arr));
    System.out.println(trapWater2(arr));
  }
}
