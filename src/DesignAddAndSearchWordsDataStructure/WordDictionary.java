package DesignAddAndSearchWordsDataStructure;

import java.util.*;


class WordDictionary {

	class TrieNode {

		Character val;
		String word;
		Map<Character, TrieNode> children;

		TrieNode(Character val) {
			this.val = val;
			children = new HashMap<>();
		}

	}

	TrieNode root;

	public WordDictionary() {
		root = new TrieNode(null);
	}

	public void addWord(String word) {
		TrieNode node = root;
		for (Character c : word.toCharArray()) {
			if (!node.children.containsKey(c)) {
				node.children.put(c, new TrieNode(c));
			}

			node = node.children.get(c);
		}

		node.word = word;
	}

	public boolean search(String word) {
		TrieNode node = root;

		boolean ans = recursion(node, word, 0);

		return ans;

	}

	boolean recursion(TrieNode node, String word, int idx) {
		if (idx == word.length() && node.word != null) {
			return true;
		} else if (idx == word.length() ) {
			return false;
		}

		Character c = word.charAt(idx);

		if (c == '.') {
			for (TrieNode child : node.children.values()) {
				if (recursion(child, word, idx + 1)) {
					return true;
				}
			}
		} else if (node.children.containsKey(c)){
			if (recursion(node.children.get(c), word, idx + 1)) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		WordDictionary test = new WordDictionary();
		test.addWord("bad");
		test.addWord("dad");
		test.addWord("mad");
		test.search("pad");
		test.search("bad");
		test.search(".ad");
		test.search("b..");
	}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */