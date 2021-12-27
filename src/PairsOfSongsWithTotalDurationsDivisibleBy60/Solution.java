package PairsOfSongsWithTotalDurationsDivisibleBy60;
import java.util.*;

class Solution {
	public int numPairsDivisibleBy60(int[] time) {
		Map<Integer, Integer> counter = new HashMap<Integer, Integer>();

		for (int i = 0; i < time.length; i++) {
			time[i] = time[i] % 60;
		}

		for (int i = 0; i < time.length; i++) {
			counter.put(time[i], counter.getOrDefault(time[i], 0) + 1);
		}

		int total = 0;

		for (int i = 0; i < time.length; i++) {
			int remainder = 60 - time[i];
			if (remainder == 60) {
				remainder = 0;
			}
			int count = counter.getOrDefault(remainder, 0);

			if (remainder == time[i]) {
				count--;
			}

			if (count > 0) {
				total += count;
			}
		}

		return total / 2;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.numPairsDivisibleBy60(new int[]{60, 60, 60});
	}
}

//
//class Solution {
//	public int numPairsDivisibleBy60(int[] time) {
//		int[] remainders = new int[60];
//
//		int count = 0;
//
//		for (int t : time) {
//			if (t % 60 == 0) {
//				count += remainders[0];
//			} else {
//				count += remainders[60 - (t % 60)];
//			}
//
//			remainders[t % 60]++;
//		}
//
//		return count;
//	}
//
//
//}