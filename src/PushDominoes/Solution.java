package PushDominoes;
import java.util.*;

class Solution {
	public String pushDominoes(String dominoes) {
		Integer first = null;
		Integer second = null;
		StringBuilder res = new StringBuilder(dominoes);
		for (int i = 0; i < dominoes.length(); i++) {
			if (dominoes.charAt(i) != '.' && first == null) {
				first = i;
			} else if (dominoes.charAt(i) != '.' && second == null) {
				second = i;
			}

			if (first != null && second != null) {
				if (dominoes.charAt(first) == 'L' && dominoes.charAt(second) == 'L') {
					first--;
					while(first >= 0 && res.charAt(first) == '.') {
						res.setCharAt(first, 'L');
						first--;
					}

					second--;
					while (second >= 0 && res.charAt(second) == '.') {
						res.setCharAt(second, 'L');
						second--;
					}
					first = null;
					second = null;
				} else if (dominoes.charAt(first) == 'L' && dominoes.charAt(second) == 'R') {
					first--;
					while(first >= 0 && res.charAt(first) == '.') {
						res.setCharAt(first, 'L');
						first--;
					}
					first = second;
					second = null;
				} else if (dominoes.charAt(first) == 'R' && dominoes.charAt(second) == 'R') {
					first++;
					while(first < dominoes.length() && res.charAt(first) == '.') {
						res.setCharAt(first, 'R');
						first++;
					}

					first = second;
					second = null;
 				} else if (dominoes.charAt(first) == 'R' && dominoes.charAt(second) == 'L') {
					first++;
					second--;

					while(res.charAt(first) == '.' && res.charAt(second) == '.' && first < second) {
						res.setCharAt(first, 'R');
						res.setCharAt(second, 'L');
						first++;
						second--;
					}

					first = null;
					second = null;
				}
			}
		}

		if (first != null && second == null && dominoes.charAt(first) == 'L') {
			first--;
			while(first >= 0 && dominoes.charAt(first) == '.') {
				res.setCharAt(first, 'L');
				first--;
			}
		} else if (first != null && second == null && dominoes.charAt(first) == 'R') {
			first++;
			while(first < dominoes.length() && dominoes.charAt(first) == '.') {
				res.setCharAt(first, 'R');
				first++;
			}
		}

		return res.toString();
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.pushDominoes("R.R.L");
	}
}