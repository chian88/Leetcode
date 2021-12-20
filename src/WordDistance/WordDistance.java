package WordDistance;
import java.util.*;

class WordDistance {
	Map<String, List<Integer>> wordLocation = new HashMap<>();

	public WordDistance(String[] wordsDict) {
		for (int i = 0; i < wordsDict.length; i++) {
			String word = wordsDict[i];
			if (!wordLocation.containsKey(word)) {
				List<Integer> location = new ArrayList<>();
				location.add(i);
				wordLocation.put(word, location);
			} else {
				List<Integer> location = wordLocation.get(word);
				location.add(i);
			}
		}
	}

	public int shortest(String word1, String word2) {
		List<Integer> word1Location = wordLocation.get(word1);
		List<Integer> word2Location = wordLocation.get(word2);

		if (word1Location != null && word2Location != null) {
			int minDist = Integer.MAX_VALUE;

			int ptr1 = 0;
			int ptr2 = 0;

			while (ptr1 < word1Location.size() && ptr2 < word2Location.size()) {
				int loc1 = word1Location.get(ptr1);
				int loc2 = word2Location.get(ptr2);
				int dist = Math.abs(loc1 - loc2);

				minDist = Math.min(dist, minDist);

				if (loc1 < loc2) {
					ptr1++;
				} else {
					ptr2++;
				}
			}


			return minDist;
		} else {
			return -1;
		}

	}

	public static void main(String[] args) {
		WordDistance test = new WordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes", "practice"});
		test.shortest("practice", "coding");
	}
}