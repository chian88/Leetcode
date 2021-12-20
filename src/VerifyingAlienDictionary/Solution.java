package VerifyingAlienDictionary;

class Solution {
    public static boolean isAlienSorted(String[] words, String order) {
        int[] charOrder = new int[26];

        for (int i = 0; i < order.length(); i++) {
            charOrder[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (j >= words[i+1].length()) return false;

                char currentWordChar = words[i].charAt(j);
                char nextWordChar = words[i + 1].charAt(j);

                if (currentWordChar != nextWordChar) {
                    if (charOrder[currentWordChar - 'a'] > charOrder[nextWordChar - 'a']) {
                        return false;
                    } else {
                        break;
                    }
                }
            }
        }


        return true;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(Solution.isAlienSorted(new String[] {"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }
}