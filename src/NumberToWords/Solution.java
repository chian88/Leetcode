package NumberToWords;
import java.util.*;


class Solution {
	public static String numberToWords(int num) {
		Map<Integer, String> mapping = new HashMap<>();

		if (num == 0) return "Zero";

		mapping.put(1000000000, " Billion ");
		mapping.put(1000000, " Million ");
		mapping.put(1000, " Thousand ");
		mapping.put(100, " Hundred ");
		mapping.put(1, "");
		StringBuilder res = new StringBuilder();

		int mask = 1000000000;

		while (num > 0) {
			int multiple = num / mask;
			if (multiple > 0) {
				res.append(numberToWordsHundred(multiple));
				res = new StringBuilder(res.toString().trim());
				res.append(mapping.get(mask));
			}


			num -= (multiple * mask);
			mask /= 1000;
		}

		return res.toString().trim();
	}

	public static String numberToWordsHundred(int num) {
		int mask = 100;
		Map<Integer, String> mapping = new HashMap<>();
		mapping.put(1, "One");
		mapping.put(2, "Two");
		mapping.put(3, "Three");
		mapping.put(4, "Four");
		mapping.put(5, "Five");
		mapping.put(6, "Six");
		mapping.put(7, "Seven");
		mapping.put(8, "Eight");
		mapping.put(9, "Nine");
		mapping.put(10, "Ten");
		mapping.put(11, "Eleven");
		mapping.put(12, "Twelve");
		mapping.put(13, "Thirteen");
		mapping.put(14, "Fourteen");
		mapping.put(15, "Fifteen");
		mapping.put(16, "Sixteen");
		mapping.put(17, "Seventeen");
		mapping.put(18, "Eighteen");
		mapping.put(19, "Nineteen");
		mapping.put(20, "Twenty");
		mapping.put(30, "Thirty");
		mapping.put(40, "Forty");
		mapping.put(50, "Fifty");
		mapping.put(60, "Sixty");
		mapping.put(70, "Seventy");
		mapping.put(80, "Eighty");
		mapping.put(90, "Ninety");


		StringBuilder res = new StringBuilder();

		if (num < 10) {
			res.append(mapping.get(num));

			return res.toString();
		}

		while (mask >= 10) {
			int multiple = num / mask;

			if (num < 10 && num > 0) {
				res.append(mapping.get(num));

				return res.toString();
			}

			if (multiple > 0) {
				if (mask == 100) {
					res.append(mapping.get(multiple));
					res.append(" Hundred ");
				} else if (mask == 10) {
					if (multiple < 2) {
						// teens
						res.append(mapping.get(num));
					} else {
						res.append(mapping.get(multiple * mask));
						res.append(" ");

						if (num % 10 > 0) {
							res.append(mapping.get(num % 10));
						} else {
							res.delete(res.length() - 1, res.length());
						}


					}
				}
			}

			num -= (multiple * mask);
			mask = mask / 10;
		}

		return res.toString();
	}

	public static void main(String[] args) {
		numberToWords(100000);
	}
}