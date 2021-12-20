package CheckIfWordEqualsSummationOfTwoWords;
import java.util.*;


class Solution {
	public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
		int a = convertToInt(firstWord);
		int b = convertToInt(secondWord);
		int c = convertToInt(targetWord);

		return a + b == c;
	}

	int convertToInt(String word) {
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < word.length(); i++) {
			str.append(word.charAt(i) - 'a');
		}

		return Integer.parseInt(str.toString());
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.isSumEqual("acb", "cba", "cdb");
	}
}