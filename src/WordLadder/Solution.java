package WordLadder;
import java.util.*;

class Pair {
	String word;
	int level;
	Pair(String word, int level) {
		this.word=  word;
		this.level = level;
	}

}

class Solution {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Map<String, List<String>> wordDictCombo = new HashMap<>();
		int L = beginWord.length();

		wordList.forEach( word -> {
			for (int i = 0; i < L; i++) {
				String transform = word.substring(0, i) + "*" + word.substring(i + 1, L);
				List<String> transformation = wordDictCombo.getOrDefault(transform, new ArrayList<>());
				transformation.add(word);
				wordDictCombo.put(transform, transformation);
			}
		});

		Deque<Pair> q = new ArrayDeque<>();

		q.addLast(new Pair(beginWord, 1));

		Set<String> seen = new HashSet<>();
		seen.add(beginWord);

		while (!q.isEmpty()) {
			Pair curr = q.pollFirst();
			String currWord = curr.word;
			int currLevel = curr.level;
			for (int i = 0; i < L; i++) {
				String transform = currWord.substring(0, i) + "*" + currWord.substring(i + 1, L);


				List<String> oneLetterDiff = wordDictCombo.getOrDefault(transform, new ArrayList<>());

				for (String diffWord : oneLetterDiff) {
					if (endWord.equals(diffWord)) {
						return currLevel + 1;
					}

					if (!seen.contains(diffWord)) {
						seen.add(diffWord);
						q.addLast(new Pair(diffWord, currLevel + 1));
					}
				}
			}
		}

		return 0;
	}
}