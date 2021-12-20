package SortIntegersByTheNumberOf1Bits;
import java.util.*;

class Solution {
	public int[] sortByBits(int[] arr) {
		List<int[]> array = new ArrayList<>();
		for (int num : arr) {
			array.add(new int[]{num, countBit(num)});
		}

		Collections.sort(array, (a, b) -> {
			int bitCmp = Integer.compare(a[1], b[1]);
			if (bitCmp != 0) {
				return bitCmp;
			}

			return Integer.compare(a[0], b[0]);
		});
		int[] res = new int[array.size()];

		for (int i = 0; i < array.size(); i++) {
			res[i] = array.get(i)[0];
		}

		return res;
	}

	int countBit(int num) {
		int res = 0;
		while (num > 0) {
			if (num % 2 == 1) {
				res++;
			}

			num = num / 2;
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.sortByBits(new int[]{0,1,2,3,4,5,6,7,8});
	}
}