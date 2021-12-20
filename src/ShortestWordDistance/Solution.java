package ShortestWordDistance;
import java.util.*;

class Solution {
	public int shortestDistance(String[] wordsDict, String word1, String word2) {
		Map<String, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < wordsDict.length; i++) {
			if (!map.containsKey(wordsDict[i])) {
				map.put(wordsDict[i], new ArrayList<>());
			}
			map.get(wordsDict[i]).add(i);
		}

		List<Integer> word1Idx = map.get(word1);
		List<Integer> word2Idx = map.get(word2);
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < word1Idx.size(); i++) {
			for (int j = 0; j < word2Idx.size(); j++) {
				res = Math.min(res, Math.abs(word1Idx.get(i) - word2Idx.get(j)));
			}
		}

		return res;
	}
}