package WordLadder2;
import java.util.*;

class Word {
	List<String> history;

	String word;

	Word(String word) {
		this.word = word;
		history = new ArrayList<>();

	}
}

class Solution {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Map<String, List<String>> graph = new HashMap<>();
		List<List<String>> res = new ArrayList<>();
		boolean found = false;
		for (String word : wordList) {
			if (word.equals(endWord)) {
				found = true;
			}
			for (int i = 0; i < word.length(); i++) {
				String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
				graph.putIfAbsent(newWord, new ArrayList<>());
				graph.get(newWord).add(word);
			}
		}

		if (!found) {
			return res;
		}

		Queue<Word> q = new LinkedList<>();
		HashSet<String> seen = new HashSet<>();
		seen.add(beginWord);
		Word firstWord = new Word(beginWord);
		q.add(firstWord);
		found = false;

		while (!q.isEmpty()) {

			int levelSize = q.size();
			Set<String> smallSeen = new HashSet<>();
			while (levelSize > 0) {
				Word curr = q.poll();
				List<String> nextWords = generateOneLetterDiff(curr.word);

				for(String nextWord : nextWords) {
					List<String> candidates = graph.get(nextWord);

					if (candidates == null) {
						continue;
					}

					for (String candidate : candidates) {
						if (seen.contains(candidate)) {
							continue;
						}

						if (candidate.equals(endWord)) {
							found = true;
							List<String> ans = new ArrayList<>(curr.history);
							ans.add(curr.word);
							ans.add(candidate);
							res.add(ans);
							break;
						}

						smallSeen.add(candidate);



						Word newWord = new Word(candidate);
						newWord.history.addAll(curr.history);
						newWord.history.add(curr.word);
						q.add(newWord);
					}
				}

				levelSize--;

			}

			seen.addAll(smallSeen);
			if (found) {
				return res;
			}

		}



		return Collections.emptyList();
	}

	List<String> generateOneLetterDiff(String word) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < word.length(); i++) {
			String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
			res.add(newWord);
		}
		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.findLadders("red", "tax", Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"));
	}
}