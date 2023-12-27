package problems.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Print matrix in spiral form */
class PrintMatrixSpiral {

  private static List<Integer> spiralPrint(int row, int column, int array[][]) {
    if(array == null){
      return Collections.emptyList();
    }

    ArrayList<Integer> spiralResult = new ArrayList<>();

    int i =0, currRow =0, currCol =0, rows = array.length-1, cols = array[0].length-1;

    while(currRow <= rows && currCol <= cols){

      for(i=currCol; i<= cols; i++){
        spiralResult.add(array[currRow][i]);
      }
      currRow++;

      for(i = currRow; i<= rows; i++){
        spiralResult.add(array[i][cols]);
      }
      cols--;

      if(currRow <= rows){
        for(i= cols; i>= currCol; i--){
          spiralResult.add(array[rows][i]);
        }
        rows--;
      }

      if(currCol <= cols){
        for(i = rows; i>= currRow; i--){
          spiralResult.add(array[i][currCol]);
        }
        currCol++;
      }


    }

    return spiralResult;
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
