package problems.recursion;

/* Generate all combination bits of given size k size using recursion */

import java.util.Arrays;

class GenerateStringOfNBits {

  private int ArrayOfBits[];

  public GenerateStringOfNBits(int sizeOfArray) {
    ArrayOfBits = new int[sizeOfArray];
  }

  public static void main(String args[]) {
    int n = 3;
    GenerateStringOfNBits nBits = new GenerateStringOfNBits(n);
    nBits.generateArray(n);
  }

  private void generateArray(int numberOfBits) {

    if (numberOfBits <= 0) {
      System.out.println(Arrays.toString(ArrayOfBits));

    } else {
      ArrayOfBits[numberOfBits - 1] = 0;
      generateArray(numberOfBits - 1);
      ArrayOfBits[numberOfBits - 1] = 1;
      generateArray(numberOfBits - 1);
    }
  }
}
