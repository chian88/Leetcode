package ConcatenatedWords;
import java.util.*;

class Solution {
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		List<String> result = new ArrayList<>();
		Set<String> preWords = new HashSet<>();
		Arrays.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});

		for (int i = 0; i < words.length; i++) {
			if (canForm(words[i], preWords)) {
				result.add(words[i]);
			}

			preWords.add(words[i]);
		}
		return result;
	}

	private boolean canForm(String word, Set<String> dict) {
		if (dict.isEmpty()) {
			return false;
		}

		boolean[] dp = new boolean[word.length() + 1];

		dp[0] = true;

		for (int i = 1; i <= word.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (!dp[j]) continue;
				if (dict.contains(word.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[word.length()];
	}

	public static void main(String[] args) {
		Solution te = new Solution();
		te.findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"});
	}
}




//class Solution {
//
//	Set<String> tempCache = new HashSet<>();
//	int min = Integer.MAX_VALUE;
//
//	public List<String> findAllConcatenatedWordsInADict(String[] words) {
//		List<String> res = new ArrayList<>();
//		Set<String> dict = new HashSet<>();
//
//		for (String word : words) {
//			if (word.length() == 0) continue;
//
//			dict.add(word);
//			min = Math.min(min, word.length());
//		}
//
//		for (String word : words) {
//			if (canForm(word, dict)) {
//				res.add(word);
//			}
//		}
//
//		return res;
//	}
//
//	boolean canForm(String word, Set<String> dict ) {
//		if (tempCache.contains(word)) return true;
//		for (int i = min; i < word.length() ; i++) {
//			String left = word.substring(0, i);
//			String right = word.substring(i);
//
//			if (dict.contains(left) &&
//					(dict.contains(right)  || canForm(right, dict))) {
//				tempCache.add(word);
//				return true;
//			}
//		}
//
//		return false;
//	}
//}