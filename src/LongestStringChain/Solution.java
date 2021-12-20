package LongestStringChain;
import java.util.*;


public class Solution {
	public int longestStrChain(String[] words) {
		HashMap<String, Integer> dp = new HashMap<>();

		HashSet<String> dict = new HashSet<>();
		dict.addAll(Arrays.asList(words));

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < words.length; i++) {
			max = Math.max(max, longestStrChainHelper(words[i], dp, dict));
		}

		return max;
	}

	private int longestStrChainHelper(String word, HashMap<String, Integer> dp, HashSet<String> dict) {

		if (dp.containsKey(word)) return dp.get(word);
		int maxLength = 1;

		for (int i = 0; i < word.length(); i++) {
			StringBuilder candidate = new StringBuilder(word);
			candidate.deleteCharAt(i);
			if (dict.contains(candidate.toString())) {
				int currentLength = 1 + longestStrChainHelper(candidate.toString(), dp, dict);
				maxLength = Math.max(maxLength, currentLength);
			}


		}

		dp.put(word, maxLength);


		return maxLength;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.longestStrChain(new String[]{"abcd", "abc", "bcd", "abd", "ab", "b"});
	}
}
