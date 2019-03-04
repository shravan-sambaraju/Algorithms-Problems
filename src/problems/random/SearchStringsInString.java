package problems.random;

/* Search string in a given strings */

import common.utils.HashMapList;

import java.util.ArrayList;
import java.util.HashMap;

class SearchStringsInString {

  private static void subtractValue(ArrayList<Integer> locations, int delta) {
    if (locations == null) {
      return;
    }
    for (int i = 0; i < locations.size(); i++) {
      locations.set(i, locations.get(i) - delta);
    }
  }

  private static Trie createTrieFromString(String s) {
    SearchStringsInString searchStringsInString = new SearchStringsInString();
    Trie trie = searchStringsInString.new Trie();
    for (int i = 0; i < s.length(); i++) {
      String suffix = s.substring(i);
      trie.insertString(suffix, i);
    }
    return trie;
  }

  private static HashMapList<String, Integer> searchAll(String big, String[] smalls) {
    HashMapList<String, Integer> lookup = new HashMapList<String, Integer>();
    Trie tree = createTrieFromString(big);
    for (String s : smalls) {
      ArrayList<Integer> locations = tree.search(s);
      subtractValue(locations, s.length());
      lookup.put(s, locations);
    }
    return lookup;
  }

  public static void main(String[] args) {
    String big = "mississippi";
    String[] smalls = {"is", "ppi", "hi", "sis", "i", "mississippi"};
    HashMapList<String, Integer> locations = searchAll(big, smalls);
    System.out.println(locations.toString());
  }

  private class Trie {
    private TrieNode root = new TrieNode();

    private ArrayList<Integer> search(String s) {
      return root.search(s);
    }

    private void insertString(String str, int location) {
      root.insertString(str, location);
    }

    private TrieNode getRoot() {
      return root;
    }
  }

  private class TrieNode {
    private HashMap<Character, TrieNode> children;
    private ArrayList<Integer> indexes;

    public TrieNode() {
      children = new HashMap<Character, TrieNode>();
      indexes = new ArrayList<Integer>();
    }

    private void insertString(String s, int index) {
      if (s == null) {
        return;
      }
      indexes.add(index);
      if (s.length() > 0) {
        char value = s.charAt(0);
        TrieNode child = null;
        if (children.containsKey(value)) {
          child = children.get(value);
        } else {
          child = new TrieNode();
          children.put(value, child);
        }
        String remainder = s.substring(1);
        child.insertString(remainder, index + 1);
      } else {
        children.put('\0', null);
      }
    }

    private ArrayList<Integer> search(String s) {
      if (s == null || s.length() == 0) {
        return indexes;
      } else {
        char first = s.charAt(0);
        if (children.containsKey(first)) {
          String remainder = s.substring(1);
          return children.get(first).search(remainder);
        }
      }
      return null;
    }

    private boolean terminates() {
      return children.containsKey('\0');
    }

    private TrieNode getChild(char c) {
      return children.get(c);
    }
  }
}
