package TopKFrequentElement;
import java.util.*;

class Structure {
	int count;
	int val;

	Structure(int count, int val) {
		this.count = count;
		this.val = val;
	}
}

class Solution {
	public int[] topKFrequent(int[] nums, int k) {
		PriorityQueue<Structure> leastCount = new PriorityQueue<>(new Comparator<Structure>() {
			@Override
			public int compare(Structure o1, Structure o2) {
				return Integer.compare(o1.count, o2.count);
			}
		});
		Map<Integer, Integer> counter = new HashMap<>();
		for (int num :  nums) {
			counter.put(num , counter.getOrDefault(num, 0) + 1);

		}

		for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
			if (leastCount.size() < k) {
				leastCount.add(new Structure(entry.getValue(), entry.getKey()));
			} else {
				if (leastCount.peek().count < entry.getValue()) {
					leastCount.poll();
					leastCount.add(new Structure(entry.getValue(), entry.getKey()));
				}
			}
		}

		int[] ans = new int[leastCount.size()];
		int ptr = 0;
		while (!leastCount.isEmpty()) {
			ans[ptr] = leastCount.poll().val;
			ptr++;
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
	}
}