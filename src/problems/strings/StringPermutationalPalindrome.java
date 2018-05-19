package problems.strings;

/* Check if given string is permutational palindrome */

public class StringPermutationalPalindrome {

	// Approach one
	static boolean isPermutationPalindrome(String s) {
		int[] table = buildCharFrequencyTable(s);
		return checkMaxOneOdd(table);

	}

	static boolean checkMaxOneOdd(int[] table) {
		boolean foundOdd = false;
		for (int count : table) {
			if (count % 2 == 1) {
				if (foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}

		return true;
	}

	static int[] buildCharFrequencyTable(String s) {
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for (char c : s.toCharArray()) {
			int x = getCharNumber(c);
			if (x != -1) {
				table[x]++;
			}
		}

		return table;
	}

	static int getCharNumber(char c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if (val >= a && val <= z) {
			return val - a;
		}

		return -1;
	}

	// Approach two

	static boolean isPermutationOfPalindrome(String s) {
		int bitVector = createBitVector(s);
		return bitVector == 0 || checkExactlyOneBitSet(bitVector);

	}

	static boolean checkExactlyOneBitSet(int bitVector) {

		return (bitVector & (bitVector - 1)) == 0;
	}

	static int createBitVector(String s) {
		int bitVector = 0;
		for (char c : s.toCharArray()) {
			int x = getCharNumber(c);
			bitVector = toggle(bitVector, x);
		}

		return bitVector;
	}

	static int toggle(int bitVector, int index) {
		if (index < 0)
			return bitVector;
		int mask = 1 << index;
		if ((bitVector & mask) == 0) {
			bitVector |= mask;
		} else {
			bitVector &= ~mask;
		}

		return bitVector;
	}

	public static void main(String args[]) {
		System.out.println(isPermutationPalindrome("tact cao"));
		System.out.println(isPermutationPalindrome("abc bbc"));
		System.out.println(isPermutationOfPalindrome("abc bbc"));
		System.out.println(isPermutationOfPalindrome("tact cao"));

	}

}
