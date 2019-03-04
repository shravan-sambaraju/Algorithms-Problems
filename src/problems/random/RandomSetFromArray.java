package problems.random;

/* Generate random set from an array */

import static common.utils.UtilMethods.intArrayToString;

class RandomSetFromArray {

    private static int rand(int lower, int higher) {
        return lower + (int) (Math.random() * (higher - lower + 1));
    }

    private static int[] pickMRecursively(int[] original, int m, int i) {
        if (i + 1 < m) {
            return null;
        } else if (i + 1 == m) {
            int[] set = new int[m];
            for (int k = 0; k < m; k++) {
                set[k] = original[k];
            }
            return set;
        } else {
            int[] set = pickMRecursively(original, m, i - 1);
            int k = rand(0, i);
            if (k < m) {
                set[k] = original[i];
            }
            return set;
        }
    }

    private static int[] pickMIteratively(int[] original, int m) {
        int[] subset = new int[m];

        for (int i = 0; i < m; i++) {
            subset[i] = original[i];
        }

        for (int i = m; i < original.length; i++) {
            int k = rand(0, i);
            if (k < m) {
                subset[k] = original[i];
            }
        }
        return subset;
    }

    public static void main(String[] args) {
        int[] cards = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(intArrayToString(cards));
        int[] set = pickMIteratively(cards, 4);
        System.out.println(intArrayToString(set));
    }
}
