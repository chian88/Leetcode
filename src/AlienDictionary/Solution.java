package AlienDictionary;
import java.util.*;


class Solution {
	public String alienOrder(String[] words) {
 		Map<Character, Set<Character>> adjacencyList = new HashMap<>();

		 for (int i = 0; i < words.length; i++) {
			 for (char c : words[i].toCharArray()) {
				 adjacencyList.putIfAbsent(c, new HashSet<>());
			 }
		 }

		for (int i = 0; i < words.length - 1; i++) {
			String wordA = words[i];
			String wordB = words[i + 1];

			int ptrA = 0, ptrB = 0;
			boolean found = false;
			while (ptrA < wordA.length() && ptrB < wordB.length()) {
				if (wordA.charAt(ptrA) == wordB.charAt(ptrB)) {
					ptrA++;
					ptrB++;
					continue;
				}

				adjacencyList.get(wordB.charAt(ptrB)).add(wordA.charAt(ptrA));
				found = true;
				break;

			}

			if (!found && wordA.length() > wordB.length()) {
				return "";
			}
		}


		Set<Character> seen = new HashSet<>();
		StringBuilder res = new StringBuilder();

		for (Map.Entry<Character, Set<Character>> entry : adjacencyList.entrySet()) {
			if (!seen.contains(entry.getKey())) {
				if(dfs(entry.getKey(), adjacencyList, seen, res, new HashSet<>())) {
					return "";
				}
			}

		}


		return res.toString();
	}

	boolean dfs(char curr, Map<Character, Set<Character>> adjacencyList, Set<Character> seen, StringBuilder res, Set<Character> currSeen) {

		Set<Character> nexts = adjacencyList.get(curr);
		seen.add(curr);
		currSeen.add(curr);
		for (char next : nexts) {
			if (currSeen.contains(next)) {
				return true;
			}

			if (!seen.contains(next)) {
				if (dfs(next, adjacencyList, seen, res, currSeen)) {
					return true;
				}
			}

		}
		currSeen.remove(curr);
		res.append(curr);
		return false;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.alienOrder(new String[]{"c", "b", "ac", "aa"});
	}
}