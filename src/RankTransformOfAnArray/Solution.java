package RankTransformOfAnArray;
import java.util.*;

class Solution {
	public int[] arrayRankTransform(int[] arr) {
		int[] newArr = Arrays.copyOf(arr, arr.length);
		Arrays.sort(newArr);
		Map<Integer, Integer> rankMap = new HashMap<>();
		int rank = 1;
		for (int i = 0; i < newArr.length; i++) {
			if (!rankMap.containsKey(newArr[i])) {
				rankMap.put(newArr[i], rank);
				rank++;
			}

		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = rankMap.get(arr[i]);
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.arrayRankTransform(new int[]{100,100,100});
	}
}