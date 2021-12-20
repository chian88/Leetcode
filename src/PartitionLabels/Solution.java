package PartitionLabels;
import java.util.*;

class Solution {
	public List<Integer> partitionLabels(String s) {
		Map<Character, Integer> mostRightIdx = new HashMap<>();
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			mostRightIdx.put(s.charAt(i), i);
		}

		int start = 0;
		int end = 0;
		int runningMax = mostRightIdx.get(s.charAt(0));
		while (end < s.length()) {
			runningMax = Math.max(runningMax, mostRightIdx.get(s.charAt(end)));

			if (end < runningMax) {
				end += 1;
			} else if (end == runningMax) {
				ans.add(end - start + 1);
				end += 1;
				start = end;

			}
		}

		return ans;

	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.partitionLabels("ababcbacadefegdehijhklij");
	}
}