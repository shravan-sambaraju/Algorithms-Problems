package tobeorganized.random;

class ProductOfRestArray {

  private static void restOfArrayMethod1(int[] array) {
    int sum = 1;
    int[] productArray = new int[array.length];

    for (int i = 0; i < array.length; i++) {
      sum = sum * array[i];
    }

    for (int i = 0; i < array.length; i++) {
      productArray[i] = sum / array[i];
    }

    for (int i = 0; i < productArray.length; i++) {
      System.out.println(productArray[i]);
    }
  }

  private static void restOfArrayMethod2(int[] array) {
    int n = array.length;
    int[] product = new int[n];
    int[] left = new int[n];
    int[] right = new int[n];

    left[0] = 1;
    right[n - 1] = 1;

    for (int i = 1; i < n; i++) {
      left[i] = array[i - 1] * left[i - 1];
    }
    for (int j = n - 2; j >= 0; j--) {
      right[j] = array[j + 1] * right[j + 1];
    }
    for (int i = 0; i < n; i++) {
      product[i] = left[i] * right[i];
      System.out.println(product[i]);
    }
  }

  private static void restOfArrayMethod3(int[] array) {
    int n = array.length;
    int[] result = new int[n];
    int temp = 1;

    for (int i = 0; i < n; i++) {
      result[i] = 1;
    }

    for (int j = 0; j < n; j++) {
      result[j] = temp;
      temp *= array[j];
    }

    temp = 1;

    for (int j = n - 1; j >= 0; j--) {
      result[j] *= temp;
      temp *= array[j];
    }

    for (int i = 0; i < n; i++) {
      System.out.println(result[i]);
    }
  }

  public static void main(String[] args) {
    ProductOfRestArray pa = new ProductOfRestArray();
    int arr[] = {1, 2, 3, 4, 5};
    int n = arr.length;
    pa.restOfArrayMethod1(arr);
    pa.restOfArrayMethod2(arr);
    pa.restOfArrayMethod3(arr);
  }
}
