package problems.random;

/* Print matrix in spiral form */

class PrintMatrixSpiral {

  private static void spiralPrint(int row, int column, int a[][]) {
    int i, k = 0, l = 0;

    while (k < row && l < column) {
      for (i = l; i < column; ++i) {
        System.out.print(a[k][i] + " ");
      }
      k++;

      for (i = k; i < row; ++i) {
        System.out.print(a[i][column - 1] + " ");
      }
      column--;

      if (k < row) {
        for (i = column - 1; i >= l; --i) {
          System.out.print(a[row - 1][i] + " ");
        }
        row--;
      }

      if (l < column) {
        for (i = row - 1; i >= k; --i) {
          System.out.print(a[i][l] + " ");
        }
        l++;
      }
    }
  }

  public static void main(String[] args) {
    int R = 4;
    int C = 6;
    int a[][] = {
      {1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {13, 14, 15, 16, 17, 18}
    };
    spiralPrint(R, C, a);
  }
}
