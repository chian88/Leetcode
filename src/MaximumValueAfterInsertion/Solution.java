package MaximumValueAfterInsertion;
import java.util.*;

class Solution {
	public String maxValue(String n, int x) {
		StringBuilder res = new StringBuilder();
		boolean already = false;
		if (n.charAt(0) == '-') {

			for (int i = 0; i < n.length(); i++) {
				if (!already && (n.charAt(i) -'0')  > x) {
					already = true;
					res.append(x);
				}

				res.append(n.charAt(i));
			}
		} else {
			for (int i = 0; i < n.length(); i++) {
				if (!already && (n.charAt(i) -'0')  < x) {
					already = true;
					res.append(x);
				}

				res.append(n.charAt(i));
			}
		}
		if (!already) {
			res.append(x);
		}
		return res.toString();
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxValue("99", 9);
	}
}