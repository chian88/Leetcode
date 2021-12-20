package KthSymbolInGrammar;
import java.util.*;


class Solution {
	public int kthGrammar(int n, int k) {
		int ans = recursion(n , k);
		return ans;
	}

	int recursion(int n , int k) {
		if (n == 1) {
			return 0;
		}

		int remainder = k % 2 ;
		int newK = (int) Math.ceil(k * 1.0 / 2.0);

		int newNum = recursion(n - 1, newK);

		if (remainder == 1) {
			if (newNum == 0) {
				return 0;
			} else {
				return 1;
			}
		} else {
			if (newNum == 0) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.kthGrammar(5, 7);
	}
}