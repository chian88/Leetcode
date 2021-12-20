package MultiplyString;
import java.util.*;

class Solution {
	public String multiply(String num1, String num2) {
		int factor = 0;
		StringBuilder sum1 = new StringBuilder();
		for (int ptr1 = num1.length() - 1; ptr1 >= 0; ptr1--) {
			StringBuilder sum2 = new StringBuilder("0".repeat(factor));
			int carry = 0;
			for (int ptr2 = num2.length() - 1; ptr2 >= 0; ptr2--) {
				int int1 = num1.charAt(ptr1) - '0';
				int int2 = num2.charAt(ptr2) - '0';

				int multiplied = int1 * int2 + carry;
				carry = multiplied / 10;
				sum2.insert(0, multiplied % 10);
			}
			if (carry > 0) {
				sum2.insert(0, carry);
			}

			sum1 = new StringBuilder(add(sum1.toString(), sum2.toString()));
			factor++;
		}

		while (sum1.length() > 1 && sum1.charAt(0) == '0') {
			sum1.deleteCharAt(0);
		}

		return sum1.toString();
	}

	public String add(String num1, String num2) {
		int ptr1 = num1.length() - 1;
		int ptr2 = num2.length() - 1;
		int carry = 0;
		StringBuilder res = new StringBuilder();
		while (ptr1 >= 0 && ptr2 >= 0) {
			int add = (num1.charAt(ptr1) - '0') + (num2.charAt(ptr2) - '0') + carry;
			carry = add / 10;
			res.insert(0, add % 10);
			ptr1--;
			ptr2--;
		}

		while (ptr1 >= 0) {
			int add = (num1.charAt(ptr1) - '0') + carry;
			carry = add / 10;
			res.insert(0, add % 10);
			ptr1--;
		}

		while (ptr2 >= 0) {
			int add = (num2.charAt(ptr2) - '0') + carry;
			carry = add / 10;
			res.insert(0, add % 10);
			ptr2--;
		}

		if (carry > 0) {
			res.insert(0, carry);
		}

		return res.toString();
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.multiply("9133", "0");
	}
}