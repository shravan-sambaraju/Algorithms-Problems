package algorithms.sorting;

/* Java implementation of selection sort */

import static common.utils.UtilMethods.intArrayToString;

class SelectionSort {

  private static int[] sort(int[] numbers) {
    int minValue, minIndex, temp;

    for (int i = 0; i < numbers.length; i++) {
      minValue = numbers[i];
      minIndex = i;

      for (int j = i; j < numbers.length; j++) {
        if (minValue > numbers[j]) {
          minValue = numbers[j];
          minIndex = j;
        }

        if (minValue < numbers[i]) {
          temp = numbers[i];
          numbers[i] = numbers[minIndex];
          numbers[minIndex] = temp;
        }
      }
    }
    return numbers;
  }

  public static void main(String[] args) {
    int[] numbers = {14, 33, 27, 35, 10, 6};
    sort(numbers);
    System.out.println(intArrayToString(numbers));
  }
}
