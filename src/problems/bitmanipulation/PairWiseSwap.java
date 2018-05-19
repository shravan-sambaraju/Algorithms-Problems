package problems.bitmanipulation;

/* Write a program to swap odd and even bits */

public class PairWiseSwap {

	public static int swapOddEvenBits(int x) {
		return (((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));
	}

	public static void main(String[] args) {
		int a = 234321;
		System.out.println(a + ": " + toFullBinaryString(a));
		int b = swapOddEvenBits(a);
		System.out.println(b + ": " + toFullBinaryString(b));
	}

	static String toFullBinaryString(int a) {
		String s = "";
		for (int i = 0; i < 32; i++) {
			Integer lsb = new Integer(a & 1);
			s = lsb.toString() + s;
			a = a >> 1;
		}
		return s;
	}

}