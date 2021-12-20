package IsomorphicString;
import java.util.*;


class Solution {
	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> sToT = new HashMap<>();
		Map<Character, Character> tToS = new HashMap<>();


		for (int i = 0; i < s.length(); i++) {
			sToT.putIfAbsent(s.charAt(i), t.charAt(i));
			tToS.putIfAbsent(t.charAt(i), s.charAt(i));

			if (sToT.get(s.charAt(i)) != t.charAt(i)) {
				return false;
			}

			if (tToS.get(t.charAt(i)) != s.charAt(i)) {
				return false;
			}
		}

		return true;
	}
}





























//class Solution {
//	public boolean isIsomorphic(String s, String t) {
//		Map<Character, Character> mapST = new HashMap<>();
//		Map<Character, Character> mapTS = new HashMap<>();
//		for (int i = 0; i < s.length(); i++) {
//			char sChr = s.charAt(i);
//			char tChr = t.charAt(i);
//
//			if (!mapST.containsKey(sChr) && !mapTS.containsKey(tChr)) {
//				mapST.put(sChr, tChr);
//				mapTS.put(tChr, sChr);
//			} else if (!mapST.containsKey(sChr)) {
//				return false;
//			} else if (!mapTS.containsKey(tChr)) {
//				return false;
//			} else {
//				if (mapST.get(sChr) != tChr || mapTS.get(tChr) != sChr) {
//					return false;
//				}
//			}
//		}
//
//		return true;
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.isIsomorphic("egg", "add");
//	}
//}