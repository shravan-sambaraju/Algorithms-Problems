package problems.bitmanipulation;

/* Number of bits required to convert a to b */

import static common.utils.UtilMethods.toFullBinaryString;

public class Conversion {

	private static int bitSwapRequired(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c >>> 1) {
			count += c & 1;
		}
		return count;
	}

	private static int bitSwapRequired2(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c & (c - 1)) {
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int a = -23432;
		int b = 512132;
		System.out.println(a + ": " + toFullBinaryString(a));
		System.out.println(b + ": " + toFullBinaryString(b));
		System.out.println("Required number of bits: " + bitSwapRequired(a, b));
		System.out.println("Required number of bits: " + bitSwapRequired2(a, b));
	}
}
