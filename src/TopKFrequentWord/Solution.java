package TopKFrequentWord;
import java.util.*;

import java.util.*;

class Solution {
	public static List<String> topKFrequent(String[] words, int k) {
		PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				int cmpCount = Integer.compare(o1.getValue(), o2.getValue());
				if (cmpCount != 0) return cmpCount;
				return o2.getKey().compareTo(o1.getKey());
			}
		});

		Map<String, Integer> wordCount = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];

			wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
		}

		for (Map.Entry<String, Integer> count : wordCount.entrySet()) {
			minHeap.add(count);

			if(minHeap.size() > k) {
				minHeap.poll();
			}
		}
		List<String> result = new LinkedList<>();

		while (minHeap.size() > 0) {
			result.add(0, minHeap.poll().getKey());
		}

		return result;
	}


	public static void main(String[] args) {
		topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
	}
}