package problems.recursion;

import java.util.Arrays;

/*
 * Given a positive integer n (and base k), generate all possible n-bit binary strings (and k-ary
 * strings of length n) using recursion and backtracking.
 */
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
