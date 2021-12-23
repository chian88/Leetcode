package CountBinaryString;

import java.util.ArrayList;
import java.util.*;

class Solution {
	public int countBinarySubstrings(String s) {
		List<Integer> group = new ArrayList<>();
		group.add(1);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i - 1) == s.charAt(i)) {
				group.set(group.size() - 1, group.get(group.size() - 1) + 1);
			} else {
				group.add(1);
			}
		}

		int res = 0;

		for (int i = 1; i < group.size(); i++) {
			res += Math.min(group.get(i - 1), group.get(i));
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.countBinarySubstrings("00110011");
	}
}


//class Solution{
//
//    public static int countBinarySubstrings(String s) {
//        int result = 0;
//        for (int i = 0; i < s.length() - 1; i++) {
//            char left = s.charAt(i);
//            char right = s.charAt(i+1);
//
//            if (left != right) {
//                result += countConsecutiveDiff(s, i, i+1);
//            }
//        }
//
//        return result;
//    }
//
//    static int countConsecutiveDiff(String s, int left, int right) {
//        char permLeftChar = s.charAt(left);
//        char permRightChar = s.charAt(right);
//
//        int count = 0;
//
//        while (left >= 0 && right < s.length()) {
//
//            char tempLeftChar = s.charAt(left);
//            char tempRightChar = s.charAt(right);
//
//            if (permLeftChar != tempLeftChar) break;
//            if (permRightChar != tempRightChar) break;
//
//            if (tempLeftChar == tempRightChar) break;
//            count++;
//            left--;
//            right++;
//        }
//
//        return count;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(Solution.countBinarySubstrings("00110011"));
//    }
//}

//class Solution {
//    public static int countBinarySubstrings(String s) {
//        int[] group = new int[s.length()];
//
//        group[0] = 1;
//
//        int team = 0;
//
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i-1) != s.charAt(i)) {
//                team+= 1;
//                group[team] = 1;
//            } else {
//                group[team] += 1;
//            }
//        }
//        int ans = 0;
//        for (int i = 0; i < group.length - 1; i ++) {
//            ans += Math.min(group[i], group[i+1]);
//        }
//
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(Solution.countBinarySubstrings("00110011"));
//    }
//}