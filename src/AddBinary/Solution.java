package AddBinary;


class Solution {
	public String addBinary(String a, String b) {
		StringBuilder res = new StringBuilder();
		StringBuilder reversedA = new StringBuilder();
		StringBuilder reversedB = new StringBuilder();

		for (int i = a.length() - 1; i >= 0; i-- ) {
			reversedA.append(a.charAt(i));
		}

		for (int i = b.length() - 1; i >= 0; i--) {
			reversedB.append(b.charAt(i));
		}
		int carry = 0;

		int ptr = 0;

		while (ptr < reversedA.length() && ptr < reversedB.length()) {
			int sum = (reversedA.charAt(ptr) - '0') + (reversedB.charAt(ptr) - '0') + carry;

			if (sum == 0) {
				res.append(0);
			} else if (sum == 1) {
				res.append(1);
				carry = 0;
			} else if (sum == 2) {
				res.append(0);
				carry = 1;
			} else if (sum == 3) {
				res.append(1);
				carry = 1;
			}

			ptr++;
		}

		while (ptr < reversedA.length()) {
			int sum = (reversedA.charAt(ptr) - '0') + carry;

			if (sum == 0) {
				res.append(0);
			} else if (sum == 1) {
				res.append(1);
				carry = 0;
			} else if (sum == 2) {
				res.append(0);
				carry = 1;
			} else if (sum == 3) {
				res.append(1);
				carry = 1;
			}

			ptr++;
		}

		while (ptr < reversedB.length()) {
			int sum = (reversedB.charAt(ptr) - '0') + carry;

			if (sum == 0) {
				res.append(0);
			} else if (sum == 1) {
				res.append(1);
				carry = 0;
			} else if (sum == 2) {
				res.append(0);
				carry = 1;
			} else if (sum == 3) {
				res.append(1);
				carry = 1;
			}

			ptr++;
		}

		if (carry == 1) {
			res.append(1);
		}

		return res.reverse().toString();

	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.addBinary("11", "1");
	}
}































//class Solution {
//    public static String addBinary(String a, String b) {
//        int p1 = a.length() - 1;
//        int p2 = b.length() - 1;
//        int carry = 0;
//        StringBuilder res = new StringBuilder();
//
//        while (p1 >=0 || p2 >= 0) {
//            int num1 = p1 >= 0 ? a.charAt(p1) - '0' : 0;
//            int num2 = p2 >= 0 ? b.charAt(p2) - '0' : 0;
//
//            int value = (num1 + num2 + carry) % 2;
//            carry = (num1 + num2 + carry) / 2;
//            res.insert(0, value);
//
//            p1--;
//            p2--;
//        }
//        if (carry > 0) {
//            res.insert(0, "1");
//        }
//
//
//        return res.toString();
//    }
//
//    public static void main(String[] args) {
//        System.out.println(Solution.addBinary("1010", "1011"));
//    }
//}