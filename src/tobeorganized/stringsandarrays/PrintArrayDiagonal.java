package tobeorganized.stringsandarrays;

import java.util.Arrays;

public class PrintArrayDiagonal {

  public static void main(String[] args) {
    //
    PrintArrayDiagonal pad = new PrintArrayDiagonal();
    int[] a = pad.findDiagonalOrder(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    System.out.println(Arrays.toString(a));
  }

  public int[] findDiagonalOrder(int[][] matrix) {
    int totalRows = matrix.length;
    if (totalRows == 0) return new int[0];
    int totalColumns = matrix[0].length;
    int[] res = new int[totalRows * totalColumns];
    String dir = "RU";
    int currentRow = 0, currentColumn = 0;
    for (int i = 0; i < totalRows * totalColumns; i++) {
      res[i] = matrix[currentRow][currentColumn];
      if (dir.equals("RU")) {
        currentRow--;
        currentColumn++;
      } else {
        currentRow++;
        currentColumn--;
      }

      if (currentRow >= totalRows) {
        currentRow = totalRows - 1;
        currentColumn += 2;
        dir = "RU";
      }
      if (currentColumn >= totalColumns) {
        currentColumn = totalColumns - 1;
        currentRow += 2;
        dir = "LD";
      }
      if (currentRow < 0) {
        currentRow = 0;
        dir = "LD";
      }
      if (currentColumn < 0) {
        currentColumn = 0;
        dir = "RU";
      }
    }
    return res;
  }
}
