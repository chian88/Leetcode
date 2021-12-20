package GroupAnagram;
import java.util.*;

class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> anagram = new HashMap<>();
		for (String str : strs) {
			String sortedStr = sortString(str);

			if (!anagram.containsKey(sortedStr)) {
				anagram.put(sortedStr, new ArrayList<>());
			}

			anagram.get(sortedStr).add(str);
		}

		List<List<String>> ans = new ArrayList<>();

		for (List<String> words : anagram.values()) {
			ans.add(words);
		}

		return ans;
	}

	String sortString(String str) {
		char[] strArr = str.toCharArray();

		Arrays.sort(strArr);

		StringBuilder res = new StringBuilder();

		for (char c : strArr) {
			res.append(c);
		}

		return res.toString();
	}
}
























//class Solution {
//	public List<List<String>> groupAnagrams(String[] strs) {
//		Map<String, List<String>> grouping = new HashMap<>();
//
//		for (String str : strs) {
//			char[] chrArr = str.toCharArray();
//			Arrays.sort(chrArr);
//			String key = new String(chrArr);
//
//
//			if (grouping.containsKey(key)) {
//				List<String> collection = grouping.get(key);
//				collection.add(str);
//			} else {
//				List<String> collection = new ArrayList<>();
//				collection.add(str);
//				grouping.put(key, collection);
//			}
//		}
//
//
//		List<List<String>> result = new ArrayList<>();
//
//		for (Map.Entry<String, List<String>> entry : grouping.entrySet()) {
//			result.add(entry.getValue());
//		}
//		return result;
//	}
//}