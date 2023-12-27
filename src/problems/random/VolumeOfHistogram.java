package problems.random;

/*
 * Imagine a histogram (bar graph). Design an algorithm to compute the volume of water it could hold
 * if someone poured water across the top. You can assume that each histogram bar has width 1.
 */
class VolumeOfHistogram {

  private static int computeHistogramVolume(int[] histo) {

    int[] leftMaxes = new int[histo.length];
    int leftMax = histo[0];
    for (int i = 0; i < histo.length; i++) {
      leftMax = Math.max(leftMax, histo[i]);
      leftMaxes[i] = leftMax;
    }

    int sum = 0;

    int rightMax = histo[histo.length - 1];
    for (int i = histo.length - 1; i >= 0; i--) {
      rightMax = Math.max(rightMax, histo[i]);
      int secondTallest = Math.min(rightMax, leftMaxes[i]);

      if (secondTallest > histo[i]) {
        sum += secondTallest - histo[i];
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    int[] histogram = {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 8, 0, 2, 0, 5, 2, 0, 3, 0, 0};
    int[] histogram2 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int result = computeHistogramVolume(histogram);
    int result2 = computeHistogramVolume(histogram2);
    System.out.println(result);
    System.out.println(result2);
  }
}
