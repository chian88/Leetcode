package ValidEmail;
import java.util.*;


class Solution {
	public int numUniqueEmails(String[] emails) {
		Set<String> uniqEmails = new HashSet<>();

		for (String email : emails) {
			String localName = email.split("@")[0];
			String domain = email.split("@")[1];
			localName = localName.replaceAll("\\.", "");
			if (localName.indexOf("+") != -1) {
				localName = localName.substring(0, localName.indexOf("+"));
			}

			uniqEmails.add(localName + "@" + domain);

		}

		return uniqEmails.size();
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.numUniqueEmails(new String[]{"a@leetcode.com","b@leetcode.com","c@leetcode.com"});
	}
}