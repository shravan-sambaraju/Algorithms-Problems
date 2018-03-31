package problems.strings;

/* Check if strings are permutations of each other */

import java.util.Arrays;

public class CheckTwoStringsArePermutations {

	public static String sort(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);

	}

	static boolean isPermutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
	}

	////// second approach

	static boolean isPermutation2(String s, String t) {
		if (s.length() != t.length()) {
			return false;

		}
		int[] letters = new int[128];
		char[] s_array = s.toCharArray();
		for (char c : s_array) {
			letters[c]++;
		}

		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			letters[c]--;
			if (letters[c] < 0) {
				return false;
			}

		}

		return true;

	}

	public static void main(String args[]) {

		System.out.println(isPermutation("abc", "bca"));
		System.out.println(isPermutation("abc", "bcd"));
		System.out.println(isPermutation2("abc", "bca"));
		System.out.println(isPermutation2("abc", "bcd"));
	}

}
