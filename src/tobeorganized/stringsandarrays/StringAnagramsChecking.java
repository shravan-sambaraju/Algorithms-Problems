package tobeorganized.stringsandarrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class StringAnagramsChecking {

  private static final Scanner scanner = new Scanner(System.in);

  // Complete the makeAnagram function below.
  static int makeAnagram(String a, String b) {
    HashMap<Character, Integer> hm = new HashMap<>();

    for (char c : a.toCharArray()) {
      hm.put(c, hm.getOrDefault(c, 0) + 1);
    }

    for (char c : b.toCharArray()) {
      hm.put(c, hm.getOrDefault(c, 0) - 1);
    }

    int count = 0;
    for (int i : hm.values()) count += Math.abs(i);

    return count;
  }

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String a = scanner.nextLine();

    String b = scanner.nextLine();

    int res = makeAnagram(a, b);

    bufferedWriter.write(String.valueOf(res));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
