package SortArrrayByIncreasingFrequency;
import java.util.*;

class Element {
	int frequency;
	int val;

	Element(int frequency, int val) {
		this.frequency = frequency;
		this.val = val;
	}
}

class Solution {
	public int[] frequencySort(int[] nums) {
		int[] counter = new int[201];
		List<Element> ls = new ArrayList<>();
		for (int num : nums) {
			counter[num + 100]++;
		}


		for (int i = 0; i < nums.length; i++) {
			ls.add(new Element(counter[nums[i] + 100], nums[i]));
		}

		Collections.sort(ls, (a, b) -> {
			int freqCmp = Integer.compare(a.frequency, b.frequency);

			if (freqCmp != 0) {
				return freqCmp;
			}

			return Integer.compare(b.val, a.val);
		});

		int[] res = new int[ls.size()];

		for (int i = 0; i < ls.size(); i++) {
			res[i] = ls.get(i).val;
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.frequencySort(new int[]{1,1,2,2,2,3});
	}
}