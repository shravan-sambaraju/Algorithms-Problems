package problems.bitmanipulation;

/* Swap bits at odd and even places */

import static common.utils.UtilMethods.toFullBinaryString;

public class PairSwap {

	private static int swapOddEvenBits(int x) {
		return (((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
	}

	public static void main(String[] args) {
		int a = 234321;
		System.out.println(a + ": " + toFullBinaryString(a));
		int b = swapOddEvenBits(a);
		System.out.println(b + ": " + toFullBinaryString(b));
	}
}
