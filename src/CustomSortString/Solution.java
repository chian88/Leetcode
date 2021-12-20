package CustomSortString;
import java.util.*;

class Solution {
	public String customSortString(String order, String s) {
		int[] sort = new int[26];

		for (int i = 0; i < order.length(); i++) {
			sort[order.charAt(i) - 'a'] = i;
		}
		char[] sArr = s.toCharArray();

		Character[] charArr = new Character[sArr.length];

		for (int i = 0; i < sArr.length; i++) {
			charArr[i] = sArr[i];
		}

		Arrays.sort(charArr, new Comparator<Character>() {
			@Override
			public int compare(Character o1, Character o2) {
				return Integer.compare(sort[o1 - 'a'], sort[o2 - 'a']);
			}
		});

		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < charArr.length; i++) {
			sb.append(charArr[i]);
		}

		return sb.toString();
	}
}