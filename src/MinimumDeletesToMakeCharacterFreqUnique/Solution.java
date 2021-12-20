package MinimumDeletesToMakeCharacterFreqUnique;
import java.util.*;

class Solution {
	public int minDeletions(String s) {
		int[] alphabetCount = new int[26];

		for (char c : s.toCharArray()) {
			alphabetCount[c - 'a'] += 1;
		}
		int maxDecrease = 0;
		for (int i = 0; i < alphabetCount.length; i++) {
			if (alphabetCount[i] <= 0) continue;

			Set<Integer> otherCount = makeSet(alphabetCount, i);

			while(otherCount.contains(alphabetCount[i])) {
				alphabetCount[i] -= 1;
				maxDecrease += 1;
			}

		}

		return maxDecrease;
	}

	private Set<Integer> makeSet(int[] numSet, int exclude) {
		int[] prev = Arrays.copyOfRange(numSet, 0, exclude);
		int[] post = Arrays.copyOfRange(numSet, exclude + 1, numSet.length);

		Set<Integer> res = new HashSet<>();

		for (int i = 0; i < prev.length; i++) {
			res.add(prev[i]);
		}

		for(int i = 0; i < post.length; i++) {
			res.add(post[i]);
		}

		res.remove(0);

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.minDeletions("aaabbbcceed");
	}
}