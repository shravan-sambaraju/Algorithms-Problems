package tobeorganized.heaps;

import java.util.PriorityQueue;

/**
 * Given a set of investment projects with their respective profits, we need to find the most
 * profitable investment projects. We will be given an initial capital, and we can start an
 * investment project only when we have the required capital. Once a project is selected, we can
 * assume that its profit has become our capital.
 *
 * <p>If we can invest only in a fixed number of projects, how can we choose projects that give us
 * maximum profit?
 */
public class MaximizeCapital {
  public static int findMaximumCapital(
      int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
    int n = profits.length;
    PriorityQueue<Integer> minCapitalHeap =
        new PriorityQueue<>(n, (i1, i2) -> capital[i1] - capital[i2]);
    PriorityQueue<Integer> maxProfitHeap =
        new PriorityQueue<>(n, (i1, i2) -> profits[i2] - profits[i1]);

    // insert all project capitals to a min-heap
    for (int i = 0; i < n; i++) minCapitalHeap.offer(i);

    // let's try to find a total of 'numberOfProjects' best projects
    int availableCapital = initialCapital;
    for (int i = 0; i < numberOfProjects; i++) {
      // find all projects that can be selected within the available capital and insert them in a
      // max-heap
      while (!minCapitalHeap.isEmpty() && capital[minCapitalHeap.peek()] <= availableCapital)
        maxProfitHeap.add(minCapitalHeap.poll());

      // terminate if we are not able to find any project that can be completed within the available
      // capital
      if (maxProfitHeap.isEmpty()) break;

      // select the project with the maximum profit
      availableCapital += profits[maxProfitHeap.poll()];
    }

    return availableCapital;
  }

  public static void main(String[] args) {
    int result = MaximizeCapital.findMaximumCapital(new int[] {0, 1, 2}, new int[] {1, 2, 3}, 2, 1);
    System.out.println("Maximum capital: " + result);
    result =
        MaximizeCapital.findMaximumCapital(new int[] {0, 1, 2, 3}, new int[] {1, 2, 3, 5}, 3, 0);
    System.out.println("Maximum capital: " + result);
  }
}
