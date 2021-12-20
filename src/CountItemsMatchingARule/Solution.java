package CountItemsMatchingARule;
import java.util.*;

class Solution {
	public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
		int res = 0;
		for (List<String> item : items) {
			if (ruleKey.equals("type") && item.get(0).equals(ruleValue)) {
				res += 1;
			} else if (ruleKey.equals("color") && item.get(1).equals(ruleValue)) {
				res += 1;
			} else if (ruleKey.equals("name") && item.get(2).equals(ruleValue)) {
				res += 1;
			}
		}

		return res;
	}
}