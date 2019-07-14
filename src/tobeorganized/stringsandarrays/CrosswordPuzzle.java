package tobeorganized.stringsandarrays;

import java.util.ArrayList;
import java.util.Scanner;

class CrosswordPuzzle {

  public static Boolean isValid(int row, int col, Character[][] map, int idx, String str) {

    if (row >= map.length || col >= map.length || row < 0 || col < 0 || map[row][col] == '+')
      return false;
    else if (map[row][col] == '-' || map[row][col] == str.charAt(idx)) return true;
    else return false;
  }

  public static Boolean findPlacement(
      int y, int x, Character[][] map, int idx, String str, int direction) {

    if (idx == str.length()) {
      return true;
    } else if (isValid(y, x, map, idx, str)) {
      Character initial = map[y][x];
      map[y][x] = str.charAt(idx);

      Boolean result = false;
      if (direction == 0) result = findPlacement(y + 1, x, map, idx + 1, str, direction);
      else if (direction == 1) result = findPlacement(y, x + 1, map, idx + 1, str, direction);
      return result;

    } else {
      return false;
    }
  }

  public static Character[][] deepCopyMatrix(Character[][] input) {
    if (input == null) return null;
    Character[][] result = new Character[input.length][];
    for (int r = 0; r < input.length; r++) {
      result[r] = input[r].clone();
    }
    return result;
  }

  public static ArrayList<Character[][]> findPossibleMaps(Character[][] map, String word) {

    ArrayList<Character[][]> results = new ArrayList<>();

    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        if (map[i][j] == '-' || map[i][j] == word.charAt(0)) {
          Character[][] newMapHoriz = deepCopyMatrix(map);
          Character[][] newMapVert = deepCopyMatrix(map);
          Boolean foundHoriz = findPlacement(i, j, newMapHoriz, 0, word, 1);
          Boolean foundVert = findPlacement(i, j, newMapVert, 0, word, 0);

          if (foundHoriz) results.add(newMapHoriz);
          if (foundVert) results.add(newMapVert);
        }
      }
    }

    return results;
  }

  public static Character[][] putNextWord(Character[][] map, int wordIdx, String[] wordDict) {
    if (wordIdx == wordDict.length) return map;
    else {
      ArrayList<Character[][]> maps = findPossibleMaps(map, wordDict[wordIdx]);

      if (maps.size() == 0) return null;
      else {
        for (int i = 0; i < maps.size(); i++) {
          Character[][] mapReturned = putNextWord(maps.get(i), wordIdx + 1, wordDict);
          if (mapReturned != null) return mapReturned;
        }
        return null;
      }
    }
  }

  public static void printMap(Character[][] map) {
    if (map == null) return;

    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        System.out.print(map[i][j]);
      }
      System.out.println("");
    }
    return;
  }

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    Character[][] initialMap = new Character[10][10];
    for (int i = 0; i < initialMap.length; i++) {
      String line = in.nextLine();
      for (int j = 0; j < initialMap[0].length; j++) {
        initialMap[i][j] = line.charAt(j);
      }
    }

    String[] mapDict = in.nextLine().split(";");
    Character[][] mapResult = putNextWord(initialMap, 0, mapDict);
    printMap(mapResult);
  }
}
