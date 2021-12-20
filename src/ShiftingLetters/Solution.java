package ShiftingLetters;
import java.util.*;

class Solution {
	public String shiftingLetters(String s, int[] shifts) {
		long[] suffixSum = new long[shifts.length];
		suffixSum[shifts.length - 1] = shifts[shifts.length - 1] % 26;
		for (int i = shifts.length - 2; i >= 0; i--) {
			suffixSum[i] = suffixSum[i + 1] + shifts[i] % 26;
		}
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i) - 'a';
			c += suffixSum[i];
			c = c % 26;
			c += 97;
			char b = (char) c ;
			res.append(b);

		}

		return res.toString();
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.shiftingLetters("mkgfzkkuxownxvfvxasy", new int[]{505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513});
	}
}