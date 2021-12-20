package SearchSuggestionsSystem;
import java.util.*;

class Solution {
	int findLowerBound(String[] products, String searchPrefix) {
		int lo = 0;
		int hi = products.length;
		int mid = -1;
		while (lo < hi) {
			mid = lo + (hi - lo) / 2;

			if (products[mid].compareTo(searchPrefix) >= 0) {
				// go left
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		return lo;
	}

	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		Arrays.sort(products);

		StringBuilder prefix = new StringBuilder();

		List<List<String>> output = new ArrayList<>();

		for (char c : searchWord.toCharArray()) {
			prefix.append(c);

			int start = findLowerBound(products, prefix.toString());

			List<String> res = new ArrayList<>();

			for (int i = start; i < start + 3 && i < products.length; i++) {
				if (products[i].length() < prefix.length()) continue;
 				String currWordPrefix = products[i].substring(0, prefix.length());
				if (currWordPrefix.equals(prefix.toString())) {
					res.add(products[i]);
				}
			}

			output.add(res);

		}

		return output;

	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.suggestedProducts(new String[]{"bags","baggage","banner","box","cloths"}, "bags");
	}


}