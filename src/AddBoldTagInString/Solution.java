package AddBoldTagInString;
import java.util.*;


class Trie {
	Map<Character, Trie> children;
	Integer length;

	Trie() {
		children = new HashMap<>();
		length = null;
	}
}

class Solution {
	public String addBoldTag(String s, String[] words) {
		Trie root = new Trie();

		for (String word : words) {
			Trie node = root;
			for (char c : word.toCharArray()) {
				if (!node.children.containsKey(c)) {
					node.children.put(c, new Trie());

				}
				node = node.children.get(c);
			}
			node.length = word.length();
		}

		List<int[]> bracketPositions = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			if (root.children.containsKey(s.charAt(i))) {
				Trie node = root;
				int iter = i;

				while (iter < s.length() && node.children.containsKey(s.charAt(iter))) {

					node = node.children.get(s.charAt(iter));
					iter++;
					if (node.length != null) {
						bracketPositions.add(new int[]{i, i + node.length});
					}
				}
			}

		}

		List<int[]> condensedBracketPosition = new LinkedList<>();

		for (int i = 0; i < bracketPositions.size(); i++) {
			int[] first = bracketPositions.get(i);
			int max = first[1];

			while ( i + 1 < bracketPositions.size() && max >= bracketPositions.get(i + 1)[0] ) {
				max = Math.max(max, bracketPositions.get(i + 1)[1]);
				i++;
			}
			condensedBracketPosition.add(new int[]{first[0], max});
		}

		StringBuilder sb = new StringBuilder();
		int ptr = 0;
		for (int i = 0; i <= s.length(); i++) {
			int[] position = null;
			if (ptr < condensedBracketPosition.size()) {
				position = condensedBracketPosition.get(ptr);
			}

			if (position != null && position[0] == i) {
				sb.append("<b>");
			}

			if (position != null && position[1] == i) {
				sb.append("</b>");
				ptr++;
			}

			if (i < s.length()) {
				sb.append(s.charAt(i));
			}

		}

		return sb.toString();
	}


	public static void main(String[] args) {
		Solution test = new Solution();
		test.addBoldTag("abcxyz123", new String[]{"abc", "123"});
	}
}