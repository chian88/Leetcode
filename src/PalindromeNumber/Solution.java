package PalindromeNumber;
import java.math.BigInteger;
import java.util.*;

class Solution {
	public static boolean isPalindrome(int x) {
		if(x < 0) return false;

		if (x < 10) return true;

		long divider = 1l;

		while (divider < x) {
			divider *= 10l;
		}

		divider /= 10l;

		long front = x;
		long end = x;

		while (end > 0) {
			long frontDigit = front / divider;
			front = front % divider;
			divider = divider / 10;

			long backDigit = end % 10;
			end = end / 10;

			if (frontDigit != backDigit) return false;
		}

		return true;

	}

	public static void main(String[] args) {
		isPalindrome(1000000001);
	}
}