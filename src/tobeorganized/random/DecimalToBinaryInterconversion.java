package tobeorganized.random;

public class DecimalToBinaryInterconversion<binaryToDecimal> {

  public static int decimalToBinaryRecursion(int decimal) {
    if (decimal == 0) {
      return 0;
    }
    return (decimal % 2 + 10 * (decimalToBinaryRecursion(decimal / 2)));
  }

  public static int decimalToBinaryIterative(int decimal) {
    StringBuilder builder = new StringBuilder();

    while (decimal > 0) {
      builder.append(decimal % 2);
      decimal /= 2;
    }
    return Integer.valueOf(builder.reverse().toString());
  }

  public static int binaryToDecimalIterative(int binary) {
    int result = 0;
    int base = 1;
    while (binary > 0) {
      int lastDigit = binary % 10;
      binary = binary / 10;
      result += lastDigit * base;
      base = base * 2;
    }
    return result;
  }

  public static int binaryToDecimalRecursive(int binary) {
    return binaryToDecimalRecursiveHelper(binary, 1);
  }

  private static int binaryToDecimalRecursiveHelper(int binary, int base) {
    if (binary == 0) {
      return 0;
    }
    if (binary == 1) {
      return base;
    }

    return binary % 10 * base + binaryToDecimalRecursiveHelper(binary / 10, base * 2);
  }

  public static void main(String[] args) {
    System.out.println(decimalToBinaryRecursion(21));
    System.out.println(decimalToBinaryIterative(21));
    System.out.println(binaryToDecimalIterative(10101));
    System.out.println(binaryToDecimalRecursive(10101));
  }
}
