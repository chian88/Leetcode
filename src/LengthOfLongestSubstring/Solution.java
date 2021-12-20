package LengthOfLongestSubstring;
// question 3

import java.util.HashSet;
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestLength = 0;
        for (int i = 0; i < s.length(); i++) {

            Set<Character> cache = new HashSet<>();

            cache.add(s.charAt(i));
            int count = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (cache.contains(s.charAt(j))) {
                    break;
                } else {
                    count+= 1;
                    cache.add(s.charAt(j));
                }
            }
            if (count > longestLength) {
                longestLength = count;

            }
        }

        return longestLength;
    }

    public static void main(String[] args) {
        Solution s1 = new Solution();
        s1.lengthOfLongestSubstring(" ");
    }
}