package FindLeastNumOfUniqueInt;
import java.util.*;

class Struct {
	int freq;
	int num;

	Struct (int freq, int num) {
		this.freq = freq;
		this.num = num;
	}


}

class Solution {
	public int findLeastNumOfUniqueInts(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		PriorityQueue<Struct> heap = new PriorityQueue<>(new Comparator<Struct>() {
			@Override
			public int compare(Struct o1, Struct o2) {
				return Integer.compare(o1.freq, o2.freq);
			}
		});

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			heap.add(new Struct(entry.getValue(), entry.getKey()));
		}
		int x = 1;
		while (k > 0) {
			if (k - heap.peek().freq < 0) break;

			k = k - heap.poll().freq;
		}
		return heap.size();
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.findLeastNumOfUniqueInts(new int[]{1}, 1);
	}
}