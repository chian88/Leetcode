package RepeatedDNASequences;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
		int left = 0;
		int right = 10;
		HashSet<String> res = new HashSet<>();
		HashSet<String> seen = new HashSet<>();
		while (right <= s.length()) {
			String subStr = s.substring(left, right);
			if (seen.contains(subStr)) {
				res.add(subStr);
			} else {
				seen.add(subStr);
			}
			left++;
			right++;
		}

		return res.stream().collect(Collectors.toList());
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
	}
}