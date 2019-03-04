package problems.random;

/* Count of twos in range */

class CountOfTwos {

    private static int count2sInRangeAtDigit(int number, int d) {
        int powerOf10 = (int) Math.pow(10, d);
        int nextPowerOf10 = powerOf10 * 10;
        int right = number % powerOf10;

        int roundDown = number - number % nextPowerOf10;
        int roundUp = roundDown + nextPowerOf10;

        int digit = (number / powerOf10) % 10;
        if (digit < 2) {
            return roundDown / 10;
        } else if (digit == 2) {
            return roundDown / 10 + right + 1;
        } else {
            return roundUp / 10;
        }
    }

    private static int count2sInRange(int number) {
        int count = 0;
        int len = String.valueOf(number).length();
        for (int digit = 0; digit < len; digit++) {
            count += count2sInRangeAtDigit(number, digit);
        }
        return count;
    }

    private static int count2sR(int n) {

        if (n == 0) {
            return 0;
        }
        int power = 1;
        while (10 * power < n) {
            power *= 10;
        }
        int first = n / power;
        int remainder = n % power;
        int nTwosFirst = 0;
        if (first > 2) {
            nTwosFirst += power;
        } else if (first == 2) {
            nTwosFirst += remainder + 1;
        }
        int nTwosOther = first * count2sR(power - 1) + count2sR(remainder);
        return nTwosFirst + nTwosOther;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            int v1 = count2sR(i);
            int v2 = count2sInRange(i);
            System.out.println("Between 0 and " + i + ": " + v1 + " " + v2);
        }
    }
}
