package tobeorganized.codingproblems;

import java.util.ArrayList;
import java.util.List;

class PrintMatrixInSpiral {

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> list = new ArrayList<Integer>();
    if (matrix.length == 0) {
      return list;
    }
    int rows = matrix.length - 1, columns = matrix[0].length - 1;
    int i = 0, currentRow = 0, currentColumn = 0;
    while (currentRow <= rows && currentColumn <= columns) {
      for (i = currentRow; i <= columns; i++) {
        list.add(matrix[currentRow][i]);
      }
      currentRow++;

      for (i = currentRow; i <= rows; i++) {
        list.add(matrix[i][columns]);
      }
      columns--;

      if (currentRow <= rows) {
        for (i = columns; i >= currentColumn; i--) {
          list.add(matrix[rows][i]);
        }
        rows--;
      }

      if (currentColumn <= columns) {
        for (i = rows; i >= currentRow; i--) {
          list.add(matrix[i][currentColumn]);
        }
        currentColumn++;
      }
    }

    return list;
  }
}
