package tobeorganized.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class MinimumSwapsToSortArray {

  private static final Scanner scanner = new Scanner(System.in);

  // Complete the minimumSwaps function below.
  static int minimumSwaps(int[] a) {
    int noOfSwaps = 0;
    int temp = 0;
    for (int i = 0; i < a.length; i++) {
      // Iterate through every element to check if a[i]=i+1
      // Under the pre-condition of consecutive integers without duplicates
      while (a[i] != (i + 1)) {
        for (int j = (i + 1); j < a.length; j++) {
          if (a[j] == (i + 1)) {
            // If found, then do the swap
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            // Count no of swaps
            noOfSwaps++;
            // Break the for loop once value found;
            break;
          }
        }
        // Break the while loop once exit(value found) from the for loop
        break;
      }
    }
    return noOfSwaps;
  }

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] arr = new int[n];

    String[] arrItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrItems[i]);
      arr[i] = arrItem;
    }

    int res = minimumSwaps(arr);

    bufferedWriter.write(String.valueOf(res));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
