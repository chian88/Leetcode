package ImplementMagicDictionary;
import java.util.*;

class MagicDictionary {
	Set<String> dict;
	public MagicDictionary() {
		this.dict = new HashSet<>();
	}

	public void buildDict(String[] dictionary) {
		for (String word : dictionary) {
			dict.add(word);
		}
	}

	public boolean search(String searchWord) {
		StringBuilder str = new StringBuilder(searchWord);

		for (int i = 0; i < searchWord.length(); i++) {
			char originalChar = searchWord.charAt(i);
			str.deleteCharAt(i);

			for (int num = 97; num <= 122; num++) {
				char chr = (char) num;
				if (originalChar == chr) {
					continue;
				}

				str.insert(i, chr);
				if (dict.contains(str.toString())) {
					return true;
				}
				str.deleteCharAt(i);

			}

			str.insert(i, originalChar);
		}

		return false;
	}

	public static void main(String[] args) {
		MagicDictionary magicDictionary = new MagicDictionary();
		magicDictionary.buildDict(new String[]{"hello", "leetcode"});
		magicDictionary.search("hello"); // return False
		magicDictionary.search("hhllo"); // We can change the second 'h' to 'e' to match "hello" so we return True
		magicDictionary.search("hell"); // return False
		magicDictionary.search("leetcoded"); // return False
	}
}
