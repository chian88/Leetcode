package LongestPalindromicSubstring;

class Solution {
    public static String longestPalindrome(String s) {
        boolean[][] cache = new boolean[s.length()][s.length()];
        int maxLength = 1;
        String maxString = s.substring(0, 1);

        // when just one character.
        for (int i = 0 ; i < s.length(); i++) {
            cache[i][i] = true;
        }

        // when just two character.
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                cache[i][i+1] = true;
                if (2 > maxLength) {
                    maxLength = 2;
                    maxString = s.substring(i,i + 2);
                }
            }
        }

        for (int end = 2; end < s.length(); end++) {
            for (int start = 0; start < s.length() - end ; start ++) {
                int realEnd = start + end;
                char startChar = s.charAt(start);
                char endChar = s.charAt(realEnd);
                if (startChar == endChar && cache[start + 1][realEnd - 1] == true) {
                    cache[start][realEnd] = true;
                    if ((realEnd - start) + 1 > maxLength) {
                        maxLength = realEnd - start + 1;
                        maxString = s.substring(start, realEnd + 1);
                    }
                }

            }
        }

        return maxString;

    }

    public static void main(String[] args) {
        System.out.println(Solution.longestPalindrome("abcba"));
    }
}