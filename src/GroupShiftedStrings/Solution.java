package GroupShiftedStrings;
import java.util.*;

class Solution {
	public List<List<String>> groupStrings(String[] strings) {
		Map<String, List<String>> res = new HashMap<>();

		for (String string : strings) {
			String key = calculateShifting(string);
			if (!res.containsKey(key)) {
				res.put(key, new ArrayList<>());
			}

			res.get(key).add(string);
		}

		List<List<String>> ans = new ArrayList<>();

		for (List<String> st : res.values()) {
			ans.add(st);
		}

		return ans;
	}

	String calculateShifting(String str) {
		StringBuilder sb = new StringBuilder();

		char[] charArr = str.toCharArray();

		for (int i = 1; i < charArr.length; i++) {
			int diff = charArr[i] - charArr[i - 1];
			if (diff < 0) {
				diff += 26;
			}
			sb.append(diff);
			sb.append(",");
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.groupStrings(new String[]{"abc","bcd","acef","xyz","az","ba","a","z"});
	}
}





























//class Pair {
//	int len;
//	List<Integer> dist;
//
//	Pair(int len, List<Integer> dist) {
//		this.len = len;
//		this.dist = dist;
//	}
//
//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (o == null || getClass() != o.getClass()) return false;
//		Pair pair = (Pair) o;
//		return len == pair.len && Objects.equals(dist, pair.dist);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(len, dist);
//	}
//}
//
//class Solution {
//	public List<List<String>> groupStrings(String[] strings) {
//		Map<Pair, List<String>> grouping = new HashMap<>();
//
//		for (String string : strings) {
//
//			if (string.length() == 1) {
//				Pair pair = new Pair(1, new ArrayList<>());
//				List<String> res = grouping.getOrDefault(pair, new ArrayList<>());
//				res.add(string);
//				grouping.put(pair, res);
//				continue;
//			}
//
//			List<Integer> dist = new ArrayList<>();
//			for (int i = 0; i < string.length() - 1; i++) {
//				int first = string.charAt(i) - 'a';
//				int second = string.charAt(i + 1) - 'a';
//				int distance = second  - first;
//				if (distance < 0) {
//					distance += 26;
//				}
//				dist.add(distance);
//			}
//			Pair pair = new Pair(string.length(), dist);
//			List<String> res = grouping.getOrDefault(pair, new ArrayList<>());
//			res.add(string);
//			grouping.put(pair, res);
//		}
//		List<List<String>> res = new ArrayList<>();
//		for (Map.Entry<Pair, List<String>> entry : grouping.entrySet()) {
//			res.add(entry.getValue());
//		}
//		return res;
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.groupStrings(new String[]{"abc","bcd","acef","xyz","az","ba","a","z"});
//	}
//}