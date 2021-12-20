package ReverseString;
import java.util.*;

class Solution {

	// recursion;
	public void reverseString(char[] s) {
		recursion(s, 0);

		int ans = 1;
	}

	void recursion(char[] s, int i) {
		if (i == s.length / 2) {
			return;
		}


		char temp = s[i];
		s[i] = s[s.length - 1 - i];
		s[s.length - 1 - i] = temp;
		recursion(s, i + 1);
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
	}


	// loop
//	public void reverseString(char[] s) {
//		int left = 0;
//		int right = s.length - 1;
//
//		while (left < right) {
//			char temp = s[left];
//			s[left] = s[right];
//			s[right] = temp;
//			left++;
//			right--;
//		}
//	}
}
















//class Solution {
//	public void reverseString(char[] s) {
//		int start = 0;
//		int end = s.length - 1;
//
//		while (start < end) {
//			char temp = s[start];
//			s[start] = s[end];
//			s[end] = temp;
//
//			start++;
//			end--;
//		}
//
//
//	}
//}