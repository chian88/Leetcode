package SentenceScreenFitting;
import java.util.*;

class Solution {
	public int wordsTyping(String[] sentence, int rows, int cols) {
		StringBuilder sb = new StringBuilder();
		for (String word : sentence) {
			sb.append(word + " ");
		}

		String sentenceStr = sb.toString();
		int sentenceLen = sentenceStr.length();

		int cursor = 0;
		for (int row = 0; row < rows; row++) {
			cursor += cols;

			if (sentenceStr.charAt(cursor % sentenceLen) == ' ') {
				cursor++;
			} else {
				while (cursor >= 0 && sentenceStr.charAt(cursor % sentenceLen) != ' ') {
					--cursor;
				}

				cursor++;
			}
		}

		return cursor / sentenceLen;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.wordsTyping(new String[]{"i", "had", "apple", "pie"}, 4, 5);
	}
}