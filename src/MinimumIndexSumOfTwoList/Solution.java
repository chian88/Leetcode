package MinimumIndexSumOfTwoList;
import java.util.*;

class Solution {
	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<Integer, List<String>> groupBySum = new HashMap<>();
		Map<String, Integer> list2ToIdx = new HashMap<>();



		for (int i = 0; i < list2.length; i++) {
			list2ToIdx.put(list2[i], i);
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < list1.length; i++) {
			if (list2ToIdx.containsKey(list1[i])) {
				int sum = i + list2ToIdx.get(list1[i]);
				groupBySum.putIfAbsent(sum, new ArrayList<>());
				groupBySum.get(sum).add(list1[i]);

				if (sum < min) {
					min = sum;
				}
			}
		}

		List<String> res = groupBySum.get(min);

		String[] ans = new String[res.size()];
		for (int i = 0; i < res.size(); i++) {
			ans[i] = res.get(i);
		}

		return ans;
	}
}