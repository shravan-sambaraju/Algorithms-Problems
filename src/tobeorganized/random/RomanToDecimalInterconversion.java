package tobeorganized.random;

import java.util.TreeMap;

public class RomanToDecimalInterconversion {

  public static int romanToInteger(String s) {
    char[] arr = s.toCharArray();
    int length = arr.length;
    int result = 0;
    int[] arr1 = new int[length];
    for (int i = 0; i < arr.length; i++) {
      switch (arr[i]) {
        case 'I':
          arr1[i] = 1;
          break;
        case 'V':
          arr1[i] = 5;
          break;
        case 'X':
          arr1[i] = 10;
          break;
        case 'L':
          arr1[i] = 50;
          break;
        case 'C':
          arr1[i] = 100;
          break;
        case 'D':
          arr1[i] = 500;
          break;
        case 'M':
          arr1[i] = 1000;
      }
    }

    for (int i = 0; i < length - 1; i++) {
      if (arr1[i] < arr1[i + 1]) {
        arr1[i] = -arr1[i];
      }
      result += arr1[i];
    }
    result += arr1[length - 1];
    return result;
  }

  public static String IntegerToRoman(int num) {
    TreeMap<Integer, String> map = new TreeMap<>();
    map.put(1, "I");
    map.put(4, "IV");
    map.put(5, "V");
    map.put(9, "IX");
    map.put(10, "X");
    map.put(40, "XL");
    map.put(50, "L");
    map.put(90, "XC");
    map.put(100, "C");
    map.put(400, "CD");
    map.put(500, "D");
    map.put(900, "CM");
    map.put(1000, "M");
    String str = "";
    while (num > 0) {
      Integer key = map.floorKey(num);
      num = num - key;
      str = str + map.get(key);
    }
    return str;
  }
}
