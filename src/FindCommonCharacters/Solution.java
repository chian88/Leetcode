package FindCommonCharacters;
import java.util.*;


class Solution {
	public List<String> commonChars(String[] words) {
		List<Map<Character, Integer>> wordMaps = new ArrayList<>();

		for (String word : words) {
			Map<Character, Integer> wordMap = new HashMap<>();
			for (char c : word.toCharArray()) {
				wordMap.put(c, wordMap.getOrDefault(c, 0) + 1);
			}
			wordMaps.add(wordMap);
		}

		Map<Character, Integer> firstWordMap = wordMaps.get(0);
		List<String> res = new ArrayList<>();
		for (Map.Entry<Character, Integer> entry : firstWordMap.entrySet()) {
			int min = entry.getValue();
			boolean foundAll = true;
			for (int i = 1; i < wordMaps.size(); i++) {
				Map<Character, Integer> wordMap = wordMaps.get(i);

				if (!wordMap.containsKey(entry.getKey())) {
					foundAll = false;
					break;
				} else {
					min = Math.min(min, wordMap.get(entry.getKey()));
				}
			}

			while (foundAll && min > 0) {
				res.add(String.valueOf(entry.getKey()));

				min--;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.commonChars(new String[] {"bella", "label", "roller"});
	}
}