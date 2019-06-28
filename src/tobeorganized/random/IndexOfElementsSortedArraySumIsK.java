package tobeorganized.random;

class IndexOfElementsSortedArraySumIsK {
  public int[] twoSum(int[] num, int target) {
    int[] indices = new int[2];
    if (num == null || num.length < 2) return indices;
    int left = 0, right = num.length - 1;
    while (left < right) {
      int v = num[left] + num[right];
      if (v == target) {
        indices[0] = left + 1;
        indices[1] = right + 1;
        break;
      } else if (v > target) {
        right--;
      } else {
        left++;
      }
    }
    return indices;
  }
}
