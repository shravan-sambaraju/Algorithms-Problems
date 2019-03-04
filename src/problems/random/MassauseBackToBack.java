package problems.random;

/* Schedule massause meeting */

class MassauseBackToBack {

    private static int maxMinutesInterativeTwoSides(int[] massages) {
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

    private static int maxMinutesIterative(int[] massages) {
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

    private static int maxMinutes(int[] massages) {
        return maxMinutes(massages, 0);
    }

    private static int maxMinutes(int[] massages, int index) {
        if (index >= massages.length) { // Out of bounds
            return 0;
        }
        int bestWith = massages[index] + maxMinutes(massages, index + 2);
        int bestWithout = maxMinutes(massages, index + 1);
        return Math.max(bestWith, bestWithout);
    }

    public static void main(String[] args) {
        int[] massages = {2 * 15, 1 * 15, 4 * 15, 5 * 15, 3 * 15, 1 * 15, 1 * 15, 3 * 15};
        System.out.println(maxMinutesInterativeTwoSides(massages));
        System.out.println(maxMinutesIterative(massages));
        System.out.println(maxMinutes(massages));
    }
}
