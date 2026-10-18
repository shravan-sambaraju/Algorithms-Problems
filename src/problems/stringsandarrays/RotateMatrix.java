package problems.stringsandarrays;

import static common.utils.UtilMethods.printMatrix;
import static common.utils.UtilMethods.randomMatrix;

/*
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a
 * method to rotate the image by 90 degrees in-place.
 */
class RotateMatrix {

  private static boolean rotate(int[][] matrix) {
    if (matrix.length == 0 || matrix.length != matrix[0].length) {
      return false;
    }
    int n = matrix.length;
    System.out.println(n);

    for (int layer = 0; layer < n / 2; layer++) {
      int first = layer;
      int last = n - 1 - layer;
      for (int i = first; i < last; i++) {
        int offset = i - first;
        int top = matrix[first][i];

        matrix[first][i] = matrix[last - offset][first];

        matrix[last - offset][first] = matrix[last][last - offset];

        matrix[last][last - offset] = matrix[i][last];

        matrix[i][last] = top;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[][] matrix = randomMatrix(5, 5, 0, 25);
    printMatrix(matrix);
    rotate(matrix);
    System.out.println();
    printMatrix(matrix);
  }
}
