package problems.random;

/* Add numbers without addition */

class AddNumbersWithoutPlus {
	private static int add(int a, int b) {
		if (b == 0)
			return a;
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return add(sum, carry);
	}

	public static void main(String[] args) {
		int a = Integer.MAX_VALUE - 50;
		int b = 92;
		int sum = add(a, b);
		int intendedSum = a + b;
		if (sum != intendedSum) {
			System.out.println("ERROR");
		} else {
			System.out.println("SUCCESS");
		}
		System.out.println(a + " + " + b + " = " + sum + " vs " + intendedSum);
	}
}