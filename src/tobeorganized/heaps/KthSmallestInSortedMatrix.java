package tobeorganized.heaps;

import java.util.PriorityQueue;

class MatrixNode {
  int row;
  int col;

  MatrixNode(int row, int col) {
    this.row = row;
    this.col = col;
  }
}

public class KthSmallestInSortedMatrix {
  public static int findKthSmallest(int[][] matrix, int k) {
    PriorityQueue<MatrixNode> minHeap =
        new PriorityQueue<MatrixNode>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);

    // put the 1st element of each row in the min heap
    // we don't need to push more than 'k' elements in the heap
    for (int i = 0; i < matrix.length && i < k; i++) minHeap.add(new MatrixNode(i, 0));

    // take the smallest (top) element form the min heap, if the running count is equal to k return
    // the number
    // if the row of the top element has more elements, add the next element to the heap
    int numberCount = 0, result = 0;
    while (!minHeap.isEmpty()) {
      MatrixNode node = minHeap.poll();
      result = matrix[node.row][node.col];
      if (++numberCount == k) break;
      node.col++;
      if (matrix[0].length > node.col) minHeap.add(node);
    }
    return result;
  }

  // alternate binary search
  public static int findKthSmallestBinarySearch(int[][] matrix, int k) {
    int n = matrix.length;
    int start = matrix[0][0], end = matrix[n - 1][n - 1];
    while (start < end) {
      int mid = start + (end - start) / 2;
      // first number is the smallest and the second number is the largest
      int[] smallLargePair = {matrix[0][0], matrix[n - 1][n - 1]};

      int count = countLessEqual(matrix, mid, smallLargePair);

      if (count == k) return smallLargePair[0];

      if (count < k) start = smallLargePair[1]; // search higher
      else end = smallLargePair[0]; // search lower
    }

    return start;
  }

  private static int countLessEqual(int[][] matrix, int mid, int[] smallLargePair) {
    int count = 0;
    int n = matrix.length, row = n - 1, col = 0;
    while (row >= 0 && col < n) {
      if (matrix[row][col] > mid) {
        // as matrix[row][col] is bigger than the mid, let's keep track of the
        // smallest number greater than the mid
        smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
        row--;
      } else {
        // as matrix[row][col] is greater than or equal to the mid, let's keep track of the
        // biggest number less than or equal to the mid
        smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
        count += row + 1;
        col++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int matrix[][] = {{2, 6, 8}, {3, 7, 10}, {5, 8, 11}};
    int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
    System.out.print("Kth smallest number is: " + result);

    int matrix4[][] = {{1, 4}, {2, 5}};
    int result2 = KthSmallestInSortedMatrix.findKthSmallestBinarySearch(matrix4, 2);
    System.out.println("Kth smallest number is: " + result2);

    int matrix1[][] = {{-5}};
    result2 = KthSmallestInSortedMatrix.findKthSmallestBinarySearch(matrix1, 1);
    System.out.println("Kth smallest number is: " + result2);

    int matrix2[][] = {{2, 6, 8}, {3, 7, 10}, {5, 8, 11}};
    result2 = KthSmallestInSortedMatrix.findKthSmallestBinarySearch(matrix2, 5);
    System.out.println("Kth smallest number is: " + result2);

    int matrix3[][] = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
    result2 = KthSmallestInSortedMatrix.findKthSmallestBinarySearch(matrix3, 8);
    System.out.println("Kth smallest number is: " + result2);
  }
}
