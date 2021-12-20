package CheckIfNAndItsDoubleExist;
import java.util.*;

class Pair {
	int val;
	int idx;
	Pair(int val, int idx) {
		this.val = val;
		this.idx = idx;
	}
}

class Solution {
	public boolean checkIfExist(int[] arr) {
		Set<Integer> set = new HashSet<>();
		int countZero = 0;
		for (int num : arr) {
			set.add(num);

			if (num == 0) {
				countZero++;
			}
		}

		if (countZero > 1) {
			return true;
		}

		for (int num : arr) {
			if (num % 2 == 0) {
				if (num == 0) {
					continue;
				}
				int target = num / 2;
				if (set.contains(target)) {
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8});
	}
}