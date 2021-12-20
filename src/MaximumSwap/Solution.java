package MaximumSwap;
import java.util.*;


class Solution {
	public int maximumSwap(int num) {
		List<Integer> numbers = new LinkedList<>();

		while (num > 0) {
			numbers.add(0, num % 10);
			num = num / 10;
		}

		List<Integer> sortedNumbers = new ArrayList<>(numbers);

		Collections.sort(sortedNumbers, Collections.reverseOrder());

		for (int i = 0; i < sortedNumbers.size(); i++) {
			if (numbers.get(i) != sortedNumbers.get(i)) {
				int target = sortedNumbers.get(i);
				int swapIdx = -1;
				for (int j = i + 1; j < numbers.size(); j++) {
					if (numbers.get(j) == target) {
						swapIdx = j;
					}

				}
				Collections.swap(numbers, i, swapIdx);
				break;
			}


		}
		int res = 0;

		for (int i = 0; i < numbers.size(); i++) {
			res *= 10;
			res += numbers.get(i);
		}


		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maximumSwap(98368);
	}
}