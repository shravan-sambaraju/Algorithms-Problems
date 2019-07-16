package tobeorganized.trees;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
  Map<Character, TrieNode> children;
  boolean isEndOfWord;

  public TrieNode() {
    children = new HashMap<Character, TrieNode>();
  }
}

class Implementation {

  TrieNode root = new TrieNode();

  public static void main(String[] args) {
    Implementation impl = new Implementation();
    impl.insert("sai");
    impl.insert("satya");
    impl.insert("shravan");
    System.out.println(impl.search("sai"));
    System.out.println(impl.search("satya"));
    System.out.println(impl.search("shravan"));
    System.out.println(impl.search("saii"));
  }

  public void insert(String word) {

    TrieNode current = root;

    for (int i = 0; i < word.length(); i++) {

      Character c = word.charAt(i);

      TrieNode node = current.children.get(c);

      if (node == null) {

        node = new TrieNode();
        current.children.put(c, node);
      }

      current = node;
    }

    current.isEndOfWord = true;
  }

  public Boolean search(String word) {

    TrieNode current = root;

    for (int i = 0; i < word.length(); i++) {

      Character c = word.charAt(i);

      TrieNode node = current.children.get(c);

      if (node == null) {
        return false;
      }
      current = node;
    }

    return current.isEndOfWord;
  }

  public void delete(String word) {
    delete(root, word, 0);
  }

  public boolean delete(TrieNode current, String word, int index) {
    if (index == word.length()) {

      if (!current.isEndOfWord) {
        return false;
      }

      current.isEndOfWord = false;
      return current.children.size() == 0;
    }

    Character ch = word.charAt(index);
    TrieNode node = current.children.get(ch);

    if (node == null) {
      return false;
    }

    boolean shouldDeleteTheNode = delete(current, word, index + 1);
    if (shouldDeleteTheNode) {
      current.children.remove(ch);
      return current.children.size() == 0;
    }

    return false;
  }
}
