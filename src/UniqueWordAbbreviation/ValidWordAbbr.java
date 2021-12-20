package UniqueWordAbbreviation;
import java.util.*;

class ValidWordAbbr {
	Map<String, Set<String>> cache;
	public ValidWordAbbr(String[] dictionary) {
		this.cache = new HashMap<>();
		for (String word : dictionary) {
			String abbr = generateAbbr(word);
			cache.putIfAbsent(abbr, new HashSet<>());

			cache.get(abbr).add(word);
		}
	}

	String generateAbbr(String word) {
		if (word.length() <= 2) {
			return word;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(word.charAt(0));
		sb.append(word.length() - 2);
		sb.append(word.charAt(word.length() - 1));

		return sb.toString();
	}

	public boolean isUnique(String word) {
		String abbr = generateAbbr(word);
		Set<String> words = cache.get(abbr);

		if (words == null) {
			return true;
		}

		if (words.size() > 1) {
			return false;
		}

		if (words.contains(word)) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		ValidWordAbbr test = new ValidWordAbbr(new String[]{"deer","door","cake","card"});
		test.isUnique("dear");
		test.isUnique("cart");
		test.isUnique("cane");
		test.isUnique("make");
		test.isUnique("cake");
	}
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */