package tobeorganized.random;

class RearrangeArray {

  public static void rearrange(int[] array) {
    for (int i = 1; i < array.length; i++) {
      if (((i % 2) == 0 && array[i - 1] < array[i]) || ((i % 2) != 0 && array[i - 1] > array[i])) {
        int temp = array[i - 1];
        array[i - 1] = array[i];
        array[i] = temp;
      }
    }
  }

  public static void main(String[] args) {}
}
