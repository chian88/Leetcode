package MatchSticksToSquare;

import java.util.*;
import java.util.stream.Collectors;


class Solution {
	public boolean makesquare(int[] matchsticks) {
		double sides = Arrays.stream(matchsticks).sum() / 4.0;

		int sidesInt = (int) sides;

		if (sides != sidesInt) {
			return false;
		}

		int[] squares = new int[4];

		List<Integer> matchst = Arrays.stream(matchsticks).boxed().collect(Collectors.toList());
		Collections.sort(matchst, Collections.reverseOrder());
		boolean ans = recursion(matchst, 0, sidesInt, squares);

		return ans;
	}

	boolean recursion(List<Integer> matchsticks, int idx, int sidesInt, int[] squares) {


		if (idx >= matchsticks.size()) {
			return squares[0] == squares[1] && squares[1] == squares[2] && squares[2] == squares[3];
		}

		int element = matchsticks.get(idx);

		for (int i = 0; i < 4; i++) {
			if (squares[i] + element <= sidesInt) {
				squares[i] += element;

				if (recursion(matchsticks, idx + 1, sidesInt, squares)) {
					return true;
				}

				squares[i] -= element;
			}
		}

		return false;
	}
	public static void main(String[] args) {
		Solution test = new Solution();
		test.makesquare(new int[]{3,1,1,2,1,2,1,1});
	}
}