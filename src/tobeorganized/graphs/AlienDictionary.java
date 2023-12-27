package tobeorganized.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * There is a dictionary containing words from an alien language for which we don’t know the
 * ordering of the characters. Write a method to find the correct order of characters in the alien
 * language.
 */
public class AlienDictionary {
  public static String findOrder(String[] words) {
    if (words == null || words.length == 0) return "";

    // a. Initialize the graph
    HashMap<Character, Integer> inDegree =
        new HashMap<>(); // count of incoming edges for every vertex
    HashMap<Character, List<Character>> graph = new HashMap<>(); // adjacency list graph
    for (String word : words) {
      for (char character : word.toCharArray()) {
        inDegree.put(character, 0);
        graph.put(character, new ArrayList<Character>());
      }
    }

    // b. Build the graph
    for (int i = 0; i < words.length - 1; i++) {
      String w1 = words[i], w2 = words[i + 1]; // find ordering of characters from adjacent words
      for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
        char parent = w1.charAt(j), child = w2.charAt(j);
        if (parent != child) { // if the two characters are different
          graph.get(parent).add(child); // put the child into it's parent's list
          inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
          break; // only the first different character between the two words will help us find the
          // order
        }
      }
    }

    // c. Find all sources i.e., all vertices with 0 in-degrees
    Queue<Character> sources = new LinkedList<>();
    for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
      if (entry.getValue() == 0) sources.add(entry.getKey());
    }

    // d. For each source, add it to the sortedOrder and subtract one from all of its children's
    // in-degrees
    // if a child's in-degree becomes zero, add it to the sources queue
    StringBuilder sortedOrder = new StringBuilder();
    while (!sources.isEmpty()) {
      Character vertex = sources.poll();
      sortedOrder.append(vertex);
      List<Character> children =
          graph.get(vertex); // get the node's children to decrement their in-degrees
      for (Character child : children) {
        inDegree.put(child, inDegree.get(child) - 1);
        if (inDegree.get(child) == 0) sources.add(child);
      }
    }

    // if sortedOrder doesn't contain all characters, there is a cyclic dependency between
    // characters, therefore, we
    // will not be able to find the correct ordering of the characters
    if (sortedOrder.length() != inDegree.size()) return "";

    return sortedOrder.toString();
  }

  public static void main(String[] args) {
    String result = AlienDictionary.findOrder(new String[] {"ba", "bc", "ac", "cab"});
    System.out.println("Character order: " + result);

    result = AlienDictionary.findOrder(new String[] {"cab", "aaa", "aab"});
    System.out.println("Character order: " + result);

    result = AlienDictionary.findOrder(new String[] {"ywx", "xww", "xz", "zyy", "zwz"});
    System.out.println("Character order: " + result);
  }
}
