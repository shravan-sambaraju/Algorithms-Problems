package problems.stringsandarrays;

/** In a given matrix if the element is 0 change the row and column consisting 0 to zeros */
import static common.utils.UtilMethods.printMatrix;
import static common.utils.UtilMethods.randomMatrix;

class ZeroMatrix2 {

  private static void nullifyRow(int[][] matrix, int row) {
    for (int j = 0; j < matrix[0].length; j++) {
      matrix[row][j] = 0;
    }
  }

  private static void nullifyColumn(int[][] matrix, int col) {
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][col] = 0;
    }
  }

  private static void setZeros(int[][] matrix) {
    boolean rowHasZero = false;
    boolean colHasZero = false;

    for (int j = 0; j < matrix[0].length; j++) {
      if (matrix[0][j] == 0) {
        rowHasZero = true;
        break;
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        colHasZero = true;
        break;
      }
    }

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for (int i = 1; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        nullifyRow(matrix, i);
      }
    }

    for (int j = 1; j < matrix[0].length; j++) {
      if (matrix[0][j] == 0) {
        nullifyColumn(matrix, j);
      }
    }

    if (rowHasZero) {
      nullifyRow(matrix, 0);
    }

    if (colHasZero) {
      nullifyColumn(matrix, 0);
    }
  }

  private static boolean matricesAreEqual(int[][] m1, int[][] m2) {
    if (m1.length != m2.length || m1[0].length != m2[0].length) {
      return false;
    }

    for (int k = 0; k < m1.length; k++) {
      for (int j = 0; j < m1[0].length; j++) {
        if (m1[k][j] != m2[k][j]) {
          return false;
        }
      }
    }
    return true;
  }

  private static int[][] cloneMatrix(int[][] matrix) {
    int[][] c = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        c[i][j] = matrix[i][j];
      }
    }
    return c;
  }

  public static void main(String[] args) {
    int nrows = 10;
    int ncols = 15;
    int[][] matrix = randomMatrix(nrows, ncols, -10, 10);

    printMatrix(matrix);
    setZeros(matrix);
    System.out.println();
    printMatrix(matrix);
  }
}
