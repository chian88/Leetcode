package MinimumChangesToMakeAlternatingBinaryString;
import java.util.*;

class Solution {
	public int minOperations(String s) {
		boolean zero = true;
		int zeroFirst = 0;
		for (char c : s.toCharArray()) {
			if (zero && c != '0') {
				zeroFirst += 1;
			} else if (!zero && c != '1') {
				zeroFirst += 1;
			}

			zero = !zero;
		}


		zero = false;
		int oneFirst = 0;
		for (char c : s.toCharArray()) {
			if (zero && c != '0') {
				oneFirst += 1;
			} else if (!zero && c != '1') {
				oneFirst += 1;
			}

			zero = !zero;
		}


		return Math.min(oneFirst, zeroFirst);
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.minOperations("1101");
	}
}