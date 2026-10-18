package tobeorganized.random;

/*
 * Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns
 * the cost of the minimum cost path to reach (m, n) from (0, 0). You can only traverse down,
 * right, and diagonally lower cells from a given cell.
 */
class MinimumCostToBuild {

  /* A utility function that returns minimum of 3 integers. */
  static int min(int x, int y, int z) {
    if (x < y) return (x < z) ? x : z;
    else return (y < z) ? y : z;
  }

  /* Returns cost of minimum cost path from (0,0) to (m, n) in mat[R][C]. */
  static int minCost(int cost[][], int m, int n) {
    if (n < 0 || m < 0) return Integer.MAX_VALUE;
    else if (m == 0 && n == 0) return cost[m][n];
    else
      return cost[m][n]
          + min(minCost(cost, m - 1, n - 1), minCost(cost, m - 1, n), minCost(cost, m, n - 1));
  }

  // Driver code
  public static void main(String args[]) {

    int cost[][] = {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};

    System.out.print(minCost(cost, 2, 2));
  }
}
