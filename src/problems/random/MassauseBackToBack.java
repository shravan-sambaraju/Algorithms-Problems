package problems.random;

public class MassauseBackToBack {
	public static int maxMinutesInterativeTwoSides(int[] massages) {
		int oneAway = 0;
		int twoAway = 0;
		for (int i = massages.length - 1; i >= 0; i--) {
			int bestWith = massages[i] + twoAway;
			int bestWithout = oneAway;
			int current = Math.max(bestWith, bestWithout);
			twoAway = oneAway;
			oneAway = current;
		}
		return oneAway;
	}
	
	
	public static int maxMinutesIterative(int[] massages) {
		/* Allocating two extra slots in the array so we don't have to do bounds
		   * checking on lines 7 and 8. */		
		int[] memo = new int[massages.length + 2];
		memo[massages.length] = 0;
		memo[massages.length + 1] = 0;
		for (int i = massages.length - 1; i >= 0; i--) {
			int bestWith = massages[i] + memo[i + 2];
			int bestWithout = memo[i + 1];
			memo[i] = Math.max(bestWith, bestWithout);
		}
		return memo[0];
	}
	
	public static int maxMinutes(int[] massages) {
		return maxMinutes(massages, 0);
	}
	
	public static int maxMinutes(int[] massages, int index) {
		if (index >= massages.length) { // Out of bounds
			return 0;
		}
		
		/* Best with this reservation. */
		int bestWith = massages[index] + maxMinutes(massages, index + 2);
		
		/* Best without this reservation. */
		int bestWithout = maxMinutes(massages, index + 1);
		
		/* Return best of this subarray, starting from index. */
		return Math.max(bestWith, bestWithout);
	}
	
	public static void main(String[] args) {
		int[] massages = {2*15, 1*15, 4*15, 5*15, 3*15, 1*15, 1*15, 3*15};
		System.out.println(maxMinutesInterativeTwoSides(massages));
		System.out.println(maxMinutesIterative(massages));
		System.out.println(maxMinutes(massages));
	}

}
