package problems.random;

/* Print trailing zeros in N factorial */

class TrailingZerosInNfactorial {

    private static int countFactZeros(int num) {
        int count = 0;
        if (num < 0) {
            System.out.println("Factorial is not defined for negative numbers");
            return 0;
        }
        for (int i = 5; num / i > 0; i *= 5) {
            count += num / i;
        }
        return count;
    }

    private static int factorial(int num) {
        if (num == 1) {
            return 1;
        } else if (num > 1) {
            return num * factorial(num - 1);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i < 12; i++) {
            System.out.println(i + "! (or " + factorial(i) + ") has " + countFactZeros(i) + " zeros");
        }
    }
}
