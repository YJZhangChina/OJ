package leetcode.java.trie;

import java.util.HashMap;
import java.util.Map;

public class P211 {

	public static void main(String[] args) {
		P211 object = new P211();
		object.addWord("bad");
		object.addWord("dad");
		object.addWord("mad");
		System.out.println(object.search("pad"));
		System.out.println(object.search("bad"));
		System.out.println(object.search(".ad"));
		System.out.println(object.search("b.."));
	}

	class P211TrieNode {

		public Map<Character, P211TrieNode> children;

		// true if the path to this node is a word exist
		public boolean exist;

		public P211TrieNode() {
			children = new HashMap<>();
			exist = false;
		}

	}

	private P211TrieNode root;

	// Change 'P211' to 'WordDictionary'
	/** Initialize your data structure here. */
	public P211() {
		root = new P211TrieNode();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		P211TrieNode node = root;
		for (int i = 0, j = word.length(); i < j; ++i) {
			char key = word.charAt(i);
			if (!node.children.containsKey(key)) {
				node.children.put(key, new P211TrieNode());
			}
			node = node.children.get(key);
		}
		node.exist = true;
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		return search(word, 1, root);
	}

	public boolean search(String word, int index, P211TrieNode node) {
		for (int i = 0, j = word.length(); i < j; ++i) {
			char key = word.charAt(i);
			if (key == '.') {
				for (char nextKey : node.children.keySet()) {
					if (search(nextKey + word.substring(index), 1, node)) {
						return true;
					}
				}
				return false;
			} else {
				if (!node.children.containsKey(key)) {
					return false;
				}
			}
			node = node.children.get(key);
			index++;
		}
		return node.exist;
	}

}
