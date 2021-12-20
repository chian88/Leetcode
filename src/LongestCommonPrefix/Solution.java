package LongestCommonPrefix;

import java.util.*;

class Solution {
	public String longestCommonPrefix(String[] strs) {
		String prefix = strs[0];

		for (int i = 1; i < strs.length; i++) {
			String str = strs[i];
			boolean cut = false;
			for (int j = 0; j < str.length() && j < prefix.length(); j++) {
				if (str.charAt(j) != prefix.charAt(j)) {
					prefix = prefix.substring(0, j);
					cut = true;
					break;
				}
			}

			if (!cut && str.length() < prefix.length()) {
				prefix = prefix.substring(0, str.length());
			}
		}

		return prefix;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.longestCommonPrefix(new String[]{"dog","racecar","car"});
	}
}





























//class Solution {
//    public static String longestCommonPrefix(String[] strs) {
//        int max = strs[0].length();
//        StringBuilder res = new StringBuilder();
//
//        for (int i = 0; i < max; i++) {
//
//            char leadChar = strs[0].charAt(i);
//            boolean allClear = true;
//            for (String str : strs) {
//                if (i >= str.length() || str.charAt(i) != leadChar) {
//                    allClear = false;
//                }
//            }
//            if (allClear == false) break;
//            res.append(leadChar);
//
//
//        }
//
//        return res.toString();
//
//    }
//
//    public static void main(String[] args) {
//        Solution.longestCommonPrefix(new String[]{"flower", "flow", "flow"});
//    }
//}