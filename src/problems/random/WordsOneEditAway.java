package problems.random;

/**
 * Given two words of equal length that are in a dictionary, write a method to transform one word
 * into another word by changing only one letter at a time.The new word you get in each step must be
 * in the dictionary.
 */
import common.utils.HashMapList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class WordsOneEditAway {

  private static LinkedList<String> transform(String startWord, String stopWord, String[] words) {
    HashMapList<String, String> wildcardToWordList = getWildcardToWordList(words);
    WordsOneEditAway wordsEdit = new WordsOneEditAway();
    BFSData sourceData = wordsEdit.new BFSData(startWord);
    BFSData destData = wordsEdit.new BFSData(stopWord);

    while (!sourceData.isFinished() && !destData.isFinished()) {

      String collision = searchLevel(wildcardToWordList, sourceData, destData);
      if (collision != null) {
        return mergePaths(sourceData, destData, collision);
      }

      collision = searchLevel(wildcardToWordList, destData, sourceData);
      if (collision != null) {
        return mergePaths(sourceData, destData, collision);
      }
    }
    return null;
  }

  private static String searchLevel(
      HashMapList<String, String> wildcardToWordList, BFSData primary, BFSData secondary) {

    int count = primary.toVisit.size();
    for (int i = 0; i < count; i++) {
      PathNode pathNode = primary.toVisit.poll();
      String word = pathNode.getWord();

      if (secondary.visited.containsKey(word)) {
        return pathNode.getWord();
      }

      ArrayList<String> words = getValidLinkedWords(word, wildcardToWordList);
      for (String w : words) {
        if (!primary.visited.containsKey(w)) {
          WordsOneEditAway wordsEdit = new WordsOneEditAway();
          PathNode next = wordsEdit.new PathNode(w, pathNode);
          primary.visited.put(w, next);
          primary.toVisit.add(next);
        }
      }
    }
    return null;
  }

  private static LinkedList<String> mergePaths(BFSData bfs1, BFSData bfs2, String connection) {
    PathNode end1 = bfs1.visited.get(connection);
    PathNode end2 = bfs2.visited.get(connection);
    LinkedList<String> pathOne = end1.collapse(false);
    LinkedList<String> pathTwo = end2.collapse(true);
    pathTwo.removeFirst();
    pathOne.addAll(pathTwo);
    return pathOne;
  }

  private static ArrayList<String> getWildcardRoots(String word) {
    ArrayList<String> words = new ArrayList<String>();
    for (int i = 0; i < word.length(); i++) {
      String w = word.substring(0, i) + "_" + word.substring(i + 1);
      words.add(w);
    }
    return words;
  }

  private static HashMapList<String, String> getWildcardToWordList(String[] words) {
    HashMapList<String, String> wildcardToWords = new HashMapList<String, String>();
    for (String word : words) {
      ArrayList<String> linked = getWildcardRoots(word);
      for (String linkedWord : linked) {
        wildcardToWords.put(linkedWord, word);
      }
    }
    return wildcardToWords;
  }

  private static ArrayList<String> getValidLinkedWords(
      String word, HashMapList<String, String> wildcardToWords) {
    ArrayList<String> wildcards = getWildcardRoots(word);
    ArrayList<String> linkedWords = new ArrayList<String>();
    for (String wildcard : wildcards) {
      ArrayList<String> words = wildcardToWords.get(wildcard);
      for (String linkedWord : words) {
        if (!linkedWord.equals(word)) {
          linkedWords.add(linkedWord);
        }
      }
    }
    return linkedWords;
  }

  public static void main(String[] args) {
    String[] words = {
      "maps", "tan", "tree", "apple", "cans", "help", "aped", "pree", "pret", "apes", "flat",
      "trap", "fret", "trip", "trie", "frat", "fril"
    };
    LinkedList<String> list = transform("tree", "flat", words);

    if (list == null) {
      System.out.println("No path.");
    } else {
      System.out.println(list.toString());
    }
  }

  private class BFSData {
    private Queue<PathNode> toVisit = new LinkedList<PathNode>();
    private HashMap<String, PathNode> visited = new HashMap<String, PathNode>();

    public BFSData(String root) {
      PathNode sourcePath = new PathNode(root, null);
      toVisit.add(sourcePath);
      visited.put(root, sourcePath);
    }

    private boolean isFinished() {
      return toVisit.isEmpty();
    }
  }

  private class PathNode {
    private String word = null;
    private PathNode previousNode = null;

    public PathNode(String word, PathNode previous) {
      this.word = word;
      previousNode = previous;
    }

    private String getWord() {
      return word;
    }

    public LinkedList<String> collapse(boolean startsWithRoot) {
      LinkedList<String> path = new LinkedList<String>();
      PathNode node = this;
      while (node != null) {
        if (startsWithRoot) {
          path.addLast(node.word);
        } else {
          path.addFirst(node.word);
        }
        node = node.previousNode;
      }
      return path;
    }
  }
}
