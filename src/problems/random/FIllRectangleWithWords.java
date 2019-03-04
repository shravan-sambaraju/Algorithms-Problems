package problems.random;

/* Fill Rectangle with words */

import java.util.ArrayList;
import java.util.HashMap;

import static common.utils.UtilMethods.getListOfWords;

class FIllRectangleWithWords {

  private int maxWordLength;
  private WordGroup[] groupList;
  private Trie trieList[];

  private FIllRectangleWithWords(String[] list) {
    groupList = WordGroup.createWordGroups(list);
    maxWordLength = groupList.length;
    trieList = new Trie[maxWordLength];
  }

  public static void main(String[] args) {
    FIllRectangleWithWords dict = new FIllRectangleWithWords(getListOfWords());
    Rectangle rect = dict.maxRectangle();
    if (rect != null) {
      rect.print();
    } else {
      System.out.println("No rectangle exists");
    }
  }

  private Rectangle maxRectangle() {
    int maxSize = maxWordLength * maxWordLength;
    for (int z = maxSize; z > 0; z--) {
      for (int i = 1; i <= maxWordLength; i++) {
        if (z % i == 0) {
          int j = z / i;
          if (j <= maxWordLength) {
            Rectangle rectangle = makeRectangle(i, j);
            if (rectangle != null) {
              return rectangle;
            }
          }
        }
      }
    }
    return null;
  }

  private Rectangle makeRectangle(int length, int height) {
    if (groupList[length - 1] == null || groupList[height - 1] == null) {
      return null;
    }
    if (trieList[height - 1] == null) {
      ArrayList<String> words = groupList[height - 1].getWords();
      trieList[height - 1] = new Trie(words);
    }
    return makePartialRectangle(length, height, new Rectangle(length));
  }

  private Rectangle makePartialRectangle(int l, int h, Rectangle rectangle) {
    if (rectangle.height == h) {
      if (rectangle.isComplete(l, h, groupList[h - 1])) {
        return rectangle;
      } else {
        return null;
      }
    }
    if (!rectangle.isPartialOK(l, trieList[h - 1])) {
      return null;
    }
    for (int i = 0; i < groupList[l - 1].length(); i++) {
      Rectangle orgPlus = rectangle.append(groupList[l - 1].getWord(i));
      Rectangle rect = makePartialRectangle(l, h, orgPlus);
      if (rect != null) {
        return rect;
      }
    }
    return null;
  }

  private static class WordGroup {
    private HashMap<String, Boolean> lookup = new HashMap<String, Boolean>();
    private ArrayList<String> group = new ArrayList<String>();

    public WordGroup() {}

    private static WordGroup[] createWordGroups(String[] list) {
      WordGroup[] groupList;
      int maxWordLength = 0;
      for (int i = 0; i < list.length; i++) {
        if (list[i].length() > maxWordLength) {
          maxWordLength = list[i].length();
        }
      }
      groupList = new WordGroup[maxWordLength];
      for (int i = 0; i < list.length; i++) {
        int wordLength = list[i].length() - 1;
        if (groupList[wordLength] == null) {
          groupList[wordLength] = new WordGroup();
        }
        groupList[wordLength].addWord(list[i]);
      }
      return groupList;
    }

    private boolean containsWord(String s) {
      return lookup.containsKey(s);
    }

    private void addWord(String s) {
      group.add(s);
      lookup.put(s, true);
    }

    private int length() {
      return group.size();
    }

    private String getWord(int i) {
      return group.get(i);
    }

    private ArrayList<String> getWords() {
      return group;
    }
  }

  private class TrieNode {

    private HashMap<Character, TrieNode> children;
    private boolean terminates = false;
    private char character;

    public TrieNode() {
      children = new HashMap<Character, TrieNode>();
    }

    private TrieNode(char character) {
      this();
      this.character = character;
    }

    private char getChar() {
      return character;
    }

    private void addWord(String word) {
      if (word == null || word.isEmpty()) {
        return;
      }

      char firstChar = word.charAt(0);

      TrieNode child = getChild(firstChar);
      if (child == null) {
        child = new TrieNode(firstChar);
        children.put(firstChar, child);
      }

      if (word.length() > 1) {
        child.addWord(word.substring(1));
      } else {
        child.setTerminates(true);
      }
    }

    private TrieNode getChild(char c) {
      return children.get(c);
    }

    private boolean terminates() {
      return terminates;
    }

    private void setTerminates(boolean t) {
      terminates = t;
    }
  }

  private class Rectangle {

    private int height;
    private int length;
    private char[][] matrix;

    public Rectangle(int len) {
      this.length = len;
    }

    private Rectangle(int length, int height, char[][] letters) {
      this.height = letters.length;
      this.length = letters[0].length;
      matrix = letters;
    }

    private char getLetter(int i, int j) {
      return matrix[i][j];
    }

    private String getColumn(int i) {
      char[] column = new char[height];
      for (int j = 0; j < height; j++) {
        column[j] = getLetter(j, i);
      }
      return new String(column);
    }

    private boolean isComplete(int l, int h, WordGroup groupList) {
      if (height == h) {
        for (int i = 0; i < l; i++) {
          String col = getColumn(i);
          if (!groupList.containsWord(col)) {
            return false;
          }
        }
        return true;
      }
      return false;
    }

    private boolean isPartialOK(int l, Trie Trie1) {
      if (height == 0) {
        return true;
      }
      for (int i = 0; i < l; i++) {
        String col = getColumn(i);
        if (!Trie1.contains(col)) {
          return false;
        }
      }
      return true;
    }

    private Rectangle append(String s) {
      if (s.length() == length) {
        char temp[][] = new char[height + 1][length];
        for (int i = 0; i < height; i++) {
          for (int j = 0; j < length; j++) {
            temp[i][j] = matrix[i][j];
          }
        }
        s.getChars(0, length, temp[height], 0);
        return new Rectangle(length, height + 1, temp);
      }
      return null;
    }

    private void print() {
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < length; j++) {
          System.out.print(matrix[i][j]);
        }
        System.out.println(" ");
      }
    }
  }

  private class Trie {
    private TrieNode root;

    public Trie(ArrayList<String> list) {
      root = new TrieNode();
      for (String word : list) {
        root.addWord(word);
      }
    }

    public Trie(String[] list) {
      root = new TrieNode();
      for (String word : list) {
        root.addWord(word);
      }
    }

    private boolean contains(String prefix, boolean exact) {
      TrieNode lastNode = root;
      int i = 0;
      for (i = 0; i < prefix.length(); i++) {
        lastNode = lastNode.getChild(prefix.charAt(i));
        if (lastNode == null) {
          return false;
        }
      }
      return !exact || lastNode.terminates();
    }

    private boolean contains(String prefix) {
      return contains(prefix, false);
    }

    private TrieNode getRoot() {
      return root;
    }
  }
}
