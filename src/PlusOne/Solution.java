package PlusOne;
import java.util.*;

class Solution {
	public int[] plusOne(int[] digits) {
		int[] res = new int[digits.length];
		int carry = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			int num = digits[i];
			if (i == digits.length -  1) {
				num = num + 1 + carry;
			} else {
				num = num + carry;
			}

			carry  = 0;
			if (num >= 10) {
				num = 0;
				carry = 1;
			}

			res[i] = num;
		}

		if (carry == 1) {
			int[] finalRes = new int[res.length + 1];
			for (int i = res.length - 1; i >= 0; i--) {
				finalRes[i] = res[i];
			}

			finalRes[0] = 1;

			return finalRes;
		}
		return res;
	}
}