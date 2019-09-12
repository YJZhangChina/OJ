package leetcode.java.trie;

public class P208 {

	class P208TrieNode {

		// words are consist of only lowercase letters
		public static final int length = 26;

		public P208TrieNode[] children;

		// true if the path to this node is a word exist
		public boolean exist;

		public P208TrieNode() {
			children = new P208TrieNode[length];
		}

		public boolean containsKey(char key) {
			return children[key - 'a'] != null;
		}

		public P208TrieNode get(char key) {
			return children[key - 'a'];
		}

		public void put(char key, P208TrieNode node) {
			children[key - 'a'] = node;
		}

	}

	private P208TrieNode root;

	// Change 'P208' to 'Trie'
	/** Initialize your data structure here. */
	public P208() {
		root = new P208TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		P208TrieNode node = root;
		for (int i = 0, j = word.length(); i < j; ++i) {
			char key = word.charAt(i);
			if (!node.containsKey(key)) {
				node.put(key, new P208TrieNode());
			}
			node = node.get(key);
		}
		node.exist = true;
	}

	public P208TrieNode searchPrefix(String word) {
		P208TrieNode node = root;
		for (int i = 0, j = word.length(); i < j; ++i) {
			char key = word.charAt(i);
			if (node.containsKey(key)) {
				node = node.get(key);
			} else {
				return null;
			}
		}
		return node;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		P208TrieNode node = searchPrefix(word);
		return node != null && node.exist;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		P208TrieNode node = searchPrefix(prefix);
		return node != null;
	}

}
