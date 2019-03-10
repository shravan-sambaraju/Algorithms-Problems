package problems.random;

/**
 * Imagine you have a square matrix, where each cell(pixel) is either black or white Design an
 * algorithm to find the maximum sub square such that all four borders are filled with black pixels.
 */
import static common.utils.UtilMethods.printMatrix;
import static common.utils.UtilMethods.randomMatrix;

class MaxSizeOfSubSquare {

  private static Subsquare findSquareWithSize(SquareCell[][] processed, int square_size) {
    int count = processed.length - square_size + 1;
    for (int row = 0; row < count; row++) {
      for (int col = 0; col < count; col++) {
        if (isSquare(processed, row, col, square_size)) {
          MaxSizeOfSubSquare mx = new MaxSizeOfSubSquare();
          return mx.new Subsquare(row, col, square_size);
        }
      }
    }
    return null;
  }

  private static Subsquare findSquare(int[][] matrix) {
    assert (matrix.length > 0);
    for (int row = 0; row < matrix.length; row++) {
      assert (matrix[row].length == matrix.length);
    }

    SquareCell[][] processed = processSquare(matrix);
    int N = matrix.length;
    for (int i = N; i >= 1; i--) {
      Subsquare square = findSquareWithSize(processed, i);
      if (square != null) {
        return square;
      }
    }
    return null;
  }

  private static boolean isSquare(SquareCell[][] matrix, int row, int col, int size) {
    SquareCell topLeft = matrix[row][col];
    SquareCell topRight = matrix[row][col + size - 1];
    SquareCell bottomRight = matrix[row + size - 1][col];
    if (topLeft.zerosRight < size) {
      return false;
    }
    if (topLeft.zerosBelow < size) {
      return false;
    }
    if (topRight.zerosBelow < size) {
      return false;
    }
    if (bottomRight.zerosRight < size) {
      return false;
    }
    return true;
  }

  private static SquareCell[][] processSquare(int[][] matrix) {
    SquareCell[][] processed = new SquareCell[matrix.length][matrix.length];

    for (int r = matrix.length - 1; r >= 0; r--) {
      for (int c = matrix.length - 1; c >= 0; c--) {
        int rightZeros = 0;
        int belowZeros = 0;
        if (matrix[r][c] == 0) {
          rightZeros++;
          belowZeros++;
          if (c + 1 < matrix.length) {
            SquareCell previous = processed[r][c + 1];
            rightZeros += previous.zerosRight;
          }
          if (r + 1 < matrix.length) {
            SquareCell previous = processed[r + 1][c];
            belowZeros += previous.zerosBelow;
          }
        }
        MaxSizeOfSubSquare mx = new MaxSizeOfSubSquare();
        processed[r][c] = mx.new SquareCell(rightZeros, belowZeros);
      }
    }
    return processed;
  }

  public static void main(String[] args) {
    int[][] matrix = randomMatrix(7, 7, 0, 1);
    printMatrix(matrix);
    Subsquare square = findSquare(matrix);
    square.print();
  }

  private class SquareCell {
    private int zerosRight = 0;
    private int zerosBelow = 0;

    public SquareCell(int right, int below) {
      zerosRight = right;
      zerosBelow = below;
    }

    private void setZerosRight(int right) {
      zerosRight = right;
    }

    private void setZerosBelow(int below) {
      zerosBelow = below;
    }
  }

  private class Subsquare {
    private int row, column, size;

    public Subsquare(int r, int c, int sz) {
      row = r;
      column = c;
      size = sz;
    }

    private void print() {
      System.out.println("(" + row + ", " + column + ", " + size + ")");
    }
  }
}
