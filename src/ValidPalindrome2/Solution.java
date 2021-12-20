package ValidPalindrome2;

public class Solution {
	public static boolean validPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;

		int chance = 1;
		boolean backCheck = true;

		while (start < end) {
			if (s.charAt(start) != s.charAt(end) && chance > 0) {
				chance--;
				end--;
			} else if (s.charAt(start) != s.charAt(end)) {
				backCheck = false;
				break;
			} else {
				start++;
				end--;
			}


		}


		start = 0;
		end = s.length() - 1;

		chance = 1;
		boolean frontCheck = true;

		while (start < end) {
			if (s.charAt(start) != s.charAt(end) && chance > 0) {
				chance--;
				start++;
			} else if (s.charAt(start) != s.charAt(end)) {
				frontCheck = false;
				break;
			} else {
				start++;
				end--;
			}


		}

		return (frontCheck || backCheck);
	}

	public static void main(String[] args) {
		validPalindrome("abc");
		validPalindrome("abca");
		validPalindrome("deeee");
	}
}
