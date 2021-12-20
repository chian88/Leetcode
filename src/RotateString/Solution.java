package RotateString;
import java.util.*;


class Solution {
	public boolean rotateString(String s, String goal) {
		StringBuilder sB = new StringBuilder(s);

		if (s.equals(goal)) {
			return true;
		}
		int tries = s.length();
		while (tries > 0) {
			char c = sB.charAt(0);
			sB.deleteCharAt(0);
			sB.append(c);
			if (sB.toString().equals(goal)) {
				return true;
			}
			tries--;
		}

		return false;
	}
}