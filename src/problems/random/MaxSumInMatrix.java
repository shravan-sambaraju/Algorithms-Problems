package problems.random;

/**
 * Given an NxN matrix of positive and negative integers, write code to find the sub matrix with the
 * largest possible sum.
 */
import static common.utils.UtilMethods.printMatrix;
import static common.utils.UtilMethods.randomMatrix;

class MaxSumInMatrix {

  private static SubMatrix getMaxMatrix(int[][] matrix) {
    int rowCount = matrix.length;
    int colCount = matrix[0].length;
    SubMatrix best = null;
    for (int rowStart = 0; rowStart < rowCount; rowStart++) {
      int[] partialSum = new int[colCount];
      for (int rowEnd = rowStart; rowEnd < rowCount; rowEnd++) {
        for (int i = 0; i < colCount; i++) {
          partialSum[i] += matrix[rowEnd][i];
        }
        Range bestRange1 = maxSubArray(partialSum, colCount);
        if (best == null || best.getSum() < bestRange1.sum) {
          MaxSumInMatrix mx = new MaxSumInMatrix();
          best =
              mx.new SubMatrix(rowStart, bestRange1.start, rowEnd, bestRange1.end, bestRange1.sum);
        }
      }
    }
    return best;
  }

  private static Range maxSubArray(int[] array, int N) {
    Range best = null;
    int start = 0;
    int sum = 0;

    for (int i = 0; i < N; i++) {
      sum += array[i];
      if (best == null || sum > best.sum) {
        MaxSumInMatrix mx = new MaxSumInMatrix();
        best = mx.new Range(start, i, sum);
      }
      if (sum < 0) {
        start = i + 1;
        sum = 0;
      }
    }
    return best;
  }

  public static void main(String[] args) {
    int[][] matrix = randomMatrix(10, 10, -5, 5);
    printMatrix(matrix);
    System.out.println(getMaxMatrix(matrix));
  }

  private class Range {
    private int start, end, sum;

    public Range(int start, int end, int sum) {
      this.start = start;
      this.end = end;
      this.sum = sum;
    }
  }

  private class SubMatrix {
    private int row1, row2, col1, col2, sum;

    public SubMatrix(int r1, int c1, int r2, int c2, int sm) {
      row1 = r1;
      col1 = c1;
      row2 = r2;
      col2 = c2;
      sum = sm;
    }

    private int getSum() {
      return sum;
    }

    @Override
    public String toString() {
      return "[(" + row1 + "," + col1 + ") -> (" + row2 + "," + col2 + ") = " + sum + "]";
    }
  }
}
