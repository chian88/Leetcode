package LetterCombinationPhoneNumber;

import javax.management.StringValueExp;
import java.util.*;

class Solution {
	// backtracking
	final static Map<Character, Character[]> mapping = Map.of('2', new Character[]{'a', 'b', 'c'},
				'3', new Character[]{'d', 'e', 'f'},
				'4', new Character[]{'g', 'h', 'i'},
				'5', new Character[]{'j', 'k', 'l'},
				'6', new Character[]{'m', 'n', 'o'},
				'7', new Character[]{'p', 'q', 'r', 's'},
				'8', new Character[]{'t', 'u', 'v'},
				'9', new Character[]{'w', 'x', 'y', 'z'});

	public static List<String> letterCombinations(String digits) {
		return letterCombinationsHelper(digits, 0, new ArrayList<>());
	}

	public static List<String> letterCombinationsHelper(String digits, int currentIdx, List<String> intermediateRes) {

		if (currentIdx == digits.length()) return intermediateRes;

		Character[] arr = mapping.get(digits.charAt(currentIdx));
		List<String> newIntermediateRes = new ArrayList<>();

		if (intermediateRes.isEmpty()) {

			for (Character c : arr) {
				newIntermediateRes.add(String.valueOf(c));
			}
		} else {
			for (String intermediate : intermediateRes) {
				for (Character c : arr) {
					newIntermediateRes.add(intermediate + c);
				}
			}

		}

		return letterCombinationsHelper(digits, currentIdx + 1, newIntermediateRes);
	}

//	public static List<String> letterCombinations(String digits) {
//		Map<Character, Character[]> mapping = Map.of('2', new Character[]{'a', 'b', 'c'},
//				'3', new Character[]{'d', 'e', 'f'},
//				'4', new Character[]{'g', 'h', 'i'},
//				'5', new Character[]{'j', 'k', 'l'},
//				'6', new Character[]{'m', 'n', 'o'},
//				'7', new Character[]{'p', 'q', 'r', 's'},
//				'8', new Character[]{'t', 'u', 'v'},
//				'9', new Character[]{'w', 'x', 'y', 'z'});
//		List<String> res = new ArrayList<>();
//		if (digits.length() == 1) {
//			Character[] arr = mapping.get(digits.charAt(0));
//			for (char c : arr) {
//				res.add( String.valueOf(c));
//			}
//		} else if (digits.length() == 2) {
//			Character[] arr1 = mapping.get(digits.charAt(0));
//			Character[] arr2 = mapping.get(digits.charAt(1));
//
//			for (char c1 : arr1) {
//				for (char c2 : arr2) {
//					res.add(c1 + String.valueOf(c2));
//				}
//			}
//		} else if (digits.length() == 3) {
//			Character[] arr1 = mapping.get(digits.charAt(0));
//			Character[] arr2 = mapping.get(digits.charAt(1));
//			Character[] arr3 = mapping.get(digits.charAt(2));
//			for (char c1 : arr1) {
//				for (char c2 : arr2) {
//					for (char c3 : arr3) {
//							res.add(c1 + String.valueOf(c2) + c3);
//					}
//
//				}
//			}
//		} else if (digits.length() == 4) {
//			Character[] arr1 = mapping.get(digits.charAt(0));
//			Character[] arr2 = mapping.get(digits.charAt(1));
//			Character[] arr3 = mapping.get(digits.charAt(2));
//			Character[] arr4 = mapping.get(digits.charAt(3));
//			for (char c1 : arr1) {
//				for (char c2 : arr2) {
//					for (char c3 : arr3) {
//						for (char c4: arr4) {
//							res.add(c1 + String.valueOf(c2) + c3 + c4);
//						}
//					}
//
//				}
//			}
//		}
//
//		return res;
//	}

	public static void main(String[] args) {
		letterCombinations("234");
	}
}