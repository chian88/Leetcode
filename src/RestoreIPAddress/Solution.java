package RestoreIPAddress;
import java.util.*;

class Solution {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();
		for (int i = 1; i < 4 && i <= s.length(); i++) {
			String firstDigit = s.substring(0, i);
			if (!checkLeadingZeros(firstDigit) || !checkValidRange(firstDigit)) {
				continue;
			}

			for (int j = i + 1; j < i + 4 && j <= s.length(); j++) {
				String secondDigit = s.substring(i, j);

				if (!checkLeadingZeros(secondDigit) || !checkValidRange(secondDigit)) {
					continue;
				}

				for (int k = j + 1; k < j + 4 && k <= s.length(); k++) {
					String thirdDigit = s.substring(j, k);
					String fourthDigit = s.substring(k);

					if (!checkLeadingZeros(thirdDigit) || !checkValidRange(thirdDigit)) {
						continue;
					}

					if (!checkLeadingZeros(fourthDigit) || !checkValidRange(fourthDigit)) {
						continue;
					}
					StringBuilder ans = new StringBuilder(firstDigit);
					ans.append(".");
					ans.append(secondDigit);
					ans.append(".");
					ans.append(thirdDigit);
					ans.append(".");
					ans.append(fourthDigit);
					res.add(ans.toString());
				}
			}
		}

		return res;
	}

	boolean checkLeadingZeros(String digit) {
		if (digit.length() == 0) {
			return false;
		}

		if (digit.length() > 1 && digit.charAt(0) == '0') {
			return false;
		}

		return true;
	}

	boolean checkValidRange(String digit) {
		if (digit.length() > 3) {
			return false;
		}

		int num = Integer.parseInt(digit);

		return num >= 0 && num <= 255;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.restoreIpAddresses("25525511135");
	}
}