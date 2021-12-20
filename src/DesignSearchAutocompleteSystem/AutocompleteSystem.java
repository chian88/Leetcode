package DesignSearchAutocompleteSystem;

import java.util.*;

class TrieNode {
	Character val;
	Map<Character, TrieNode> children;
	Set<Integer> possibleWordIdx;

	TrieNode(Character val) {
		this.val = val;
		possibleWordIdx = new HashSet<>();
		children = new HashMap<>();
	}

	void insertWord(String s, int idx) {
		TrieNode node = this;
		for (char c : s.toCharArray()) {

			if (!node.children.containsKey(c)) {
				node.children.put(c, new TrieNode(c));
			}

			node = node.children.get(c);
			node.possibleWordIdx.add(idx);
		}
	}
}

class Word {
	int hotIndex;
	String word;

	Word (String word, int hotIndex) {
		this.word = word;
		this.hotIndex = hotIndex;
	}
}


class AutocompleteSystem {

	TrieNode root;
	Map<String, Integer> hotIndex;
	StringBuilder stringInProgress;
	List<String> sentencesList;

	public AutocompleteSystem(String[] sentences, int[] times) {
		root = new TrieNode(null);
		hotIndex = new HashMap<>();
		stringInProgress = new StringBuilder();
		this.sentencesList = new ArrayList(Arrays.asList(sentences));

		for (int i = 0; i < sentences.length; i++) {
			root.insertWord(sentences[i], i);

		}

		for (int i = 0; i < times.length; i++) {
			hotIndex.put(sentences[i], times[i]);
		}
	}

	public List<String> input(char c) {
		if (c == '#') {
			// reset stringinprogress and update hot index. and return empty list.
			String str = stringInProgress.toString();

			Integer existingHotIndex = hotIndex.get(str);

			if (existingHotIndex == null) {
				hotIndex.put(str, 1);
				sentencesList.add(str);
				root.insertWord(str, sentencesList.size() - 1);
			} else {
				hotIndex.put(str, existingHotIndex + 1);
			}




			stringInProgress = new StringBuilder();


			return Collections.emptyList();
		} else {
			stringInProgress.append(c);
			TrieNode node = root;
			for (char ch : stringInProgress.toString().toCharArray()) {


				if (node.children.containsKey(ch)) {
					node = node.children.get(ch);
				} else {
					return Collections.emptyList();
				}
			}

			Set<Integer> possibleWordIdx = node.possibleWordIdx;

			PriorityQueue<Word> heap = new PriorityQueue<>( (a, b) -> {
				int hotCompare = Integer.compare(b.hotIndex, a.hotIndex);

				if (hotCompare != 0) {
					return hotCompare;
				}

				return a.word.compareTo(b.word);
			});

			for (Integer idx : possibleWordIdx) {
				heap.add(new Word(sentencesList.get(idx), hotIndex.get(sentencesList.get(idx))));
			}

			List<String> res = new ArrayList<>();

			while (!heap.isEmpty() && res.size() < 3) {
				res.add(heap.poll().word);
			}

			return res;
		}


	}

	public static void main(String[] args) {
		AutocompleteSystem test = new AutocompleteSystem(new String[]{"i love you", "island", "iroman", "i love leetcode"}, new int[]{5, 3, 2, 2});
		test.input('i');
		test.input(' ');
		test.input('a');
		test.input('#');

	}
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */