package problems.random;

/* Search string in a given strings */

import java.util.ArrayList;
import java.util.HashMap;

public class SearchStringsInString {
	public static void subtractValue(ArrayList<Integer> locations, int delta) {
		if (locations == null)
			return;
		for (int i = 0; i < locations.size(); i++) {
			locations.set(i, locations.get(i) - delta);
		}
	}

	public static Trie createTrieFromString(String s) {
		Trie trie = new Trie();
		for (int i = 0; i < s.length(); i++) {
			String suffix = s.substring(i);
			trie.insertString(suffix, i);
		}
		return trie;
	}

	public static HashMapList<String, Integer> searchAll(String big, String[] smalls) {
		HashMapList<String, Integer> lookup = new HashMapList<String, Integer>();
		Trie tree = createTrieFromString(big);
		for (String s : smalls) {
			/* Get terminating location of each occurrence. */
			ArrayList<Integer> locations = tree.search(s);

			/* Adjust to starting location. */
			subtractValue(locations, s.length());

			/* Insert. */
			lookup.put(s, locations);
		}

		return lookup;
	}

	public static void main(String[] args) {
		String big = "mississippi";
		String[] smalls = { "is", "ppi", "hi", "sis", "i", "mississippi" };
		HashMapList<String, Integer> locations = searchAll(big, smalls);
		System.out.println(locations.toString());
	}
}

class Trie {
	private TrieNode root = new TrieNode();

	public ArrayList<Integer> search(String s) {
		return root.search(s);
	}

	public void insertString(String str, int location) {
		root.insertString(str, location);
	}

	public TrieNode getRoot() {
		return root;
	}
}

class TrieNode {
	private HashMap<Character, TrieNode> children;
	private ArrayList<Integer> indexes;

	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
		indexes = new ArrayList<Integer>();
	}

	public void insertString(String s, int index) {
		if (s == null)
			return;
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

	public ArrayList<Integer> search(String s) {
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

	public boolean terminates() {
		return children.containsKey('\0');
	}

	public TrieNode getChild(char c) {
		return children.get(c);
	}
}