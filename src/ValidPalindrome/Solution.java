package ValidPalindrome;

public class Solution {
	public static boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			char front = Character.toLowerCase(s.charAt(start));
			char back = Character.toLowerCase(s.charAt(end));

			if (!Character.isLetterOrDigit(front)) {
				start++;
				continue;
			} else if (!Character.isLetterOrDigit(back)) {
				end--;
				continue;
			} else if (front != back) {
				return false;
			}
			start++;
			end--;
		}

		return true;
	}

	public static void main(String[] args) {
		isPalindrome("A man, a plan, a canal: Panama");
	}

}
