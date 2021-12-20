package ImplementTrie;
import java.util.*;

class Trie {
	class TrieNode {
		Character val;
		boolean isWord = false;
		Map<Character, TrieNode> children = new HashMap<>();

		TrieNode(Character val) {
			this.val = val;
		}
	}
	/** Initialize your data structure here. */
	TrieNode root;

	public Trie() {
		this.root = new TrieNode(null);
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode curr = root;
		for (char c : word.toCharArray()) {
			if (!curr.children.containsKey(c)) {
				curr.children.put(c, new TrieNode(c));
			}
			curr = curr.children.get(c);
		}
		curr.isWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode curr = root;
		for (char c : word.toCharArray()) {
			if (!curr.children.containsKey(c)) {
				return false;
			}

			curr = curr.children.get(c);
		}

		return curr.isWord;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		TrieNode curr = root;
		for (char c : prefix.toCharArray()) {
			if (!curr.children.containsKey(c)) {
				return false;
			}

			curr = curr.children.get(c);
		}

		return true;
	}

	public static void main(String[] args) {
		Trie test = new Trie();
		test.insert("apple");
		test.search("appl");
		test.search("apple");
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */