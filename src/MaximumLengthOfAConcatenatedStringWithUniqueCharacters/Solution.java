package MaximumLengthOfAConcatenatedStringWithUniqueCharacters;
import java.util.*;

class Solution {
	public int maxLength(List<String> arr) {
		int[] counter = new int[26];
		int ans = recursion(arr, 0, counter);
		return ans;
	}

	int recursion(List<String> arr, int startIdx, int[] counter) {
		if (startIdx >= arr.size()) {
			return 0;
		}


		int maxWordSize = 0;



		for ( int i = startIdx; i < arr.size(); i++) {
			String word = arr.get(i);
			if (!countChar(counter, word)) {
				maxWordSize = Math.max(maxWordSize, word.length() + recursion(arr, i + 1, counter));
			}

			decountChar(counter, word);
		}

		return maxWordSize;
	}

	void decountChar(int[] counter, String word) {
		for (char c : word.toCharArray()) {
			counter[c - 'a']--;
		}
	}

	boolean countChar(int[] counter, String word) {
		boolean res = false;
		for (char c : word.toCharArray()) {
			counter[c - 'a']++;
			if (counter[c - 'a'] >= 2) {
				res = true;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxLength(Arrays.asList("un", "iq", "ue"));
	}
}