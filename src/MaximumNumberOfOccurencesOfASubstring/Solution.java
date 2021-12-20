package MaximumNumberOfOccurencesOfASubstring;
import java.util.*;


class Solution {
	public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
		if(s == null || s.length() == 0 || maxLetters == 0) return 0;
		HashMap<String, Integer> hm = new HashMap<>();
		int max = 0;
		for(int i = 0; i < s.length() - minSize + 1; i++) {
			String cur = s.substring(i, i + minSize);
			if(isValid(cur, maxLetters)) {
				hm.put(cur, hm.getOrDefault(cur, 0) + 1);
				max = Math.max(max, hm.get(cur));
			}
		}
		return max;
	}

	boolean isValid(String cur, int maxLetters) {
		// length of cur  = minSize and makes this method run O(1)
		HashSet<Character> hs = new HashSet<>();
		for(char c: cur.toCharArray()) hs.add(c);
		return hs.size() <= maxLetters;
	}
}

//class Solution {
//	public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
//		Map<String, Integer> counter = new HashMap<>();
//		int max = 0;
//		for (int size = minSize; size <= maxSize; size++) {
//
//			Map<Character, Integer> uniq = createNewUniq(s, size);
//
//
//			for (int i = 0; i <= s.length() - size; i++) {
//
//				if (i - 1 >= 0) {
//					uniq.put(s.charAt(i - 1), uniq.get(s.charAt(i - 1)) - 1);
//
//					if (uniq.get(s.charAt( i - 1)) == 0) {
//						uniq.remove(s.charAt(i - 1));
//					}
//
//				}
//				uniq.put(s.charAt(i + size - 1), uniq.getOrDefault(s.charAt(i + size - 1), 0) + 1);
//
//				if (uniq.size() > maxLetters) {
//					continue;
//				}
//
//				String target = s.substring(i, i + size);
//				counter.put(target, counter.getOrDefault(target, 0) + 1);
//				max = Math.max(max, counter.get(target));
//			}
//		}
//
//
//		return max;
//
//	}
//
//	Map<Character, Integer> createNewUniq(String s, int size) {
//		Map<Character, Integer> uniq = new HashMap<>();
//		for (int i = 0; i < size - 1; i++) {
//			uniq.put(s.charAt(i), uniq.getOrDefault(s.charAt(i), 0) + 1);
//		}
//
//		return uniq;
//	}
//
//	boolean checkUniqueChar(String target, int maxLetters) {
//		Set<Character> uniq = new HashSet<>();
//		for (int i = 0 ; i < target.length(); i++) {
//			uniq.add(target.charAt(i));
//		}
//
//		return uniq.size() <= maxLetters;
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.maxFreq("aababcaab", 2, 3, 4);
//	}
//}