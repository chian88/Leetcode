package FindAndReplacePattern;
import java.util.*;

class Solution {
	public List<String> findAndReplacePattern(String[] words, String pattern) {

		List<String> res = new ArrayList<>();

		for (String word : words) {
			if (word.length() != pattern.length()) {
				continue;
			}
			Map<Character, Character> hashA = new HashMap<>();
			Map<Character, Character> hashB = new HashMap<>();
			boolean foundWord = true;
			for (int i = 0; i < word.length(); i++) {
				if (!hashA.containsKey(pattern.charAt(i))) {
					hashA.put(pattern.charAt(i), word.charAt(i));
				}

				if (!hashB.containsKey(word.charAt(i))) {
					hashB.put(word.charAt(i), pattern.charAt(i));
				}
				char newA = hashA.get(pattern.charAt(i));
				char newB = hashB.get(word.charAt(i));

				if (newA != word.charAt(i) || newB != pattern.charAt(i)) {
					foundWord = false;
					break;
				}

			}

			if (foundWord) {
				res.add(word);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "abb");
	}
}