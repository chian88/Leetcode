package HappyNumber;
import java.util.*;

class Solution {
	public boolean isHappy(int n) {
		Set<Integer> seen = new HashSet<>();
		while (n != 1) {
			n = breakAndSquare(n);
			if (seen.contains(n)) {
				return false;
			}
			seen.add(n);
		}

		return true;
	}

	int breakAndSquare(int n) {
		int res = 0;
		while (n > 0) {
			res += (n % 10) * (n % 10);
			n = n /10;

		}

		return res;
	}
}
























//
//class Solution {
//	public boolean isHappy(int n) {
//		long num = n;
//		HashSet<Long> seen = new HashSet<>();
//		seen.add(num);
//		while (num != 1) {
//			num = breakDownAndSquare(num);
//			if (seen.contains(num)) return false;
//			seen.add(num);
//		}
//		return true;
//	}
//
//	long breakDownAndSquare(long num) {
//		long res = 0;
//		while (num > 0) {
//			res += Math.pow(num % 10, 2);
//			num = num / 10;
//		}
//
//		return res;
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.isHappy(19);
//	}
//}