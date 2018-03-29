package problems.recursion;

/* Generate all the string of n bits . where an array of k size using recursion */

import java.util.Arrays;

public class GenerateStringOfNBits {
	int ArrayOfBits[];

	public GenerateStringOfNBits() {

	}

	public GenerateStringOfNBits(int sizeOfArray) {
		ArrayOfBits = new int[sizeOfArray];
	}

	public void generateArray(int numberOfBits) {

		if (numberOfBits <= 0) {
			System.out.println(Arrays.toString(ArrayOfBits));

		} else {
			ArrayOfBits[numberOfBits - 1] = 0;
			generateArray(numberOfBits - 1);
			ArrayOfBits[numberOfBits - 1] = 1;
			generateArray(numberOfBits - 1);

		}

	}

	public static void main(String args[]) {
		int n = 3;
		GenerateStringOfNBits nBits = new GenerateStringOfNBits(n);
		nBits.generateArray(n);

	}

}
