package tobeorganized.recursion;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberMnemonics {

  public static final String[] letters = {
    "0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"
  };

  public static List<String> phoneMnemonic(String phoneNumber) {
    List<String> mnemonics = new ArrayList<>();
    phoneMnemonicHelper(phoneNumber, 0, new char[phoneNumber.length()], mnemonics);

    return mnemonics;
  }

  private static void phoneMnemonicHelper(
      String phoneNumber, int digit, char[] partialMnemonic, List<String> mnemonics) {
    if (digit == phoneNumber.length()) {
      mnemonics.add(new String(partialMnemonic));
    } else {
      for (int i = 0; i < letters[phoneNumber.charAt(digit) - '0'].length(); i++) {
        char c = letters[phoneNumber.charAt(digit) - '0'].charAt(i);
        partialMnemonic[digit] = c;
        phoneMnemonicHelper(phoneNumber, digit + 1, partialMnemonic, mnemonics);
      }
    }
  }

  public static List<String> letterCombinations(String digits) {
    if (digits == null) return null;
    List<String> res = new ArrayList<String>();
    res.add("");
    for (int i = 0; i < digits.length(); i++) {
      String letter = letters[digits.charAt(i) - '0'];
      List<String> newRes = new ArrayList<String>();
      for (int j = 0; j < letter.length(); j++) {
        for (String s : res) {
          s += letter.charAt(j);
          newRes.add(s);
        }
      }
      res = newRes;
    }
    return res;
  }

  public static void main(String[] args) {
    List<String> strings = phoneMnemonic("2276696");
    List<String> strings2 = letterCombinations("2276696");
    System.out.println(strings.toString());
    System.out.println(strings2.toString());
  }
}
