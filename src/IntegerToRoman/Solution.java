package IntegerToRoman;
import java.util.*;
import java.util.stream.*;

class Solution {
	private static final Map<Integer, String> intToRomanMapping =  Stream.of (
			new AbstractMap.SimpleEntry<>(1, "I"),
			new AbstractMap.SimpleEntry<>(4, "IV"),
			new AbstractMap.SimpleEntry<>(5, "V"),
			new AbstractMap.SimpleEntry<>(9, "IX"),
			new AbstractMap.SimpleEntry<>(10, "X"),
			new AbstractMap.SimpleEntry<>(40, "XL"),
			new AbstractMap.SimpleEntry<>(50, "L"),
			new AbstractMap.SimpleEntry<>(90, "XC"),
			new AbstractMap.SimpleEntry<>(100, "C"),
			new AbstractMap.SimpleEntry<>(400, "CD"),
			new AbstractMap.SimpleEntry<>(500, "D"),
			new AbstractMap.SimpleEntry<>(900, "CM"),
			new AbstractMap.SimpleEntry<>(1000, "M")
	).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

	public static String intToRoman(int num) {
		int[] denomination = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		int ptr = 0;
		StringBuilder result = new StringBuilder();
		while (num > 0) {
			if (num >= denomination[ptr]) {
				result.append(intToRomanMapping.get(denomination[ptr]));
				num -= denomination[ptr];
			} else {
				ptr++;
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		intToRoman(1994);
	}
}