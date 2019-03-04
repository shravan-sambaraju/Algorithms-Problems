package algorithms.sorting;

/* Java implementation of bubble sort */

class BubbleSort {

  private static void sortNumbers(int[] numbers) {
    int temp = 0;
    for (int i = 0; i < numbers.length; i++) {
      for (int j = 1; j < numbers.length - i; j++) {
        if (numbers[j] < numbers[j - 1]) {
          temp = numbers[j - 1];
          numbers[j - 1] = numbers[j];
          numbers[j] = temp;
          for (int n : numbers) {
            System.out.print(" " + n);
          }
          System.out.print(";");
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] numbers = {14, 33, 27, 35, 10};
    sortNumbers(numbers);
    for (int n : numbers) {
      System.out.println(" ");
      System.out.print(n);
    }
  }
}
