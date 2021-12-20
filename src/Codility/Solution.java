package Codility;
import java.util.*;


class Solution {
    public static String solution(String riddle) {
        // write your code in Java SE 8
        int pointer = 0;
        StringBuilder result = new StringBuilder(riddle);

        for (int i = 0; i < result.length(); i++) {
            Character left = (i-1) >= 0 ? result.charAt(i-1) : null;
            Character right = (i+1) < result.length() ?  result.charAt(i+1) : null;

            Character current = result.charAt(i);

            char potentialChar = (char) (pointer + 97);
            if (current == '?') {
                while ( (  left != null  && potentialChar == left ) || ( right != null && potentialChar == right) ) {
                    pointer++;
                    pointer = pointer % 26;
                    potentialChar = (char) (pointer + 97);
                }

                result.setCharAt(i, potentialChar);
                pointer++;
                pointer = pointer % 26;
            }

        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(Solution.solution("ab?ac?"));
    }
}


//class Solution {
//    public static String solution(String S) {
//        // write your code in Java SE 8
//
//        List<Character> upper = new ArrayList<>();
//        List<Character> lower = new ArrayList<>();
//        for (int i = 0; i < S.length(); i++) {
//            char c = S.charAt(i);
//
//            if (Character.isUpperCase(c)) {
//                upper.add(c);
//            } else if (Character.isLowerCase(c)) {
//                lower.add(c);
//            }
//        }
//
//        Collections.sort(upper, Collections.reverseOrder());
//        Collections.sort(lower, Collections.reverseOrder());
//
//        for (int i = 0 ; i < upper.size(); i++) {
//            char upperCharInLowerCase = Character.toLowerCase(upper.get(i));
//
//            for (int j = 0 ; j < lower.size(); j++) {
//                char lowerChar = lower.get(j);
//
//                if (upperCharInLowerCase == lowerChar) {
//                    return String.valueOf(upper.get(i));
//                }
//            }
//
//        }
//
//
//        return "NO";
//    }
//
//    public static void main(String[] args) {
//        Solution.solution("aaBabcDaA");
//
//
//    }
//}
