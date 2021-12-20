package SubarraySumEqualsK;

import java.lang.invoke.SerializedLambda;
import java.util.*;

class Solution {
	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> counter = new HashMap<>();

		int[] prefixSum = new int[nums.length + 1];

		prefixSum[0] = 0;

		for (int i = 0; i < nums.length; i++) {
			prefixSum[i + 1] = prefixSum[i] + nums[i];
		}
		int res = 0;
		counter.put(0, 1);
		for (int i = 1; i < prefixSum.length; i++) {
			int target = prefixSum[i] - k;
			if (counter.containsKey(target)) {
				res += counter.get(target);
			}

			counter.put(prefixSum[i], counter.getOrDefault(prefixSum[i], 0) + 1);
		}
		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.subarraySum(new int[]{1,3,-2,7,-6,6}, 1);
	}
}

























//// double loop,  count sum every loop O(n^2)
//class Solution {
//    public int subarraySum(int[] nums, int k) {
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 0;
//
//            for (int j = i; j < nums.length; j++) {
//                sum += nums[j];
//                if (sum == k) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//
//    public static void main(String[] args) {
//        Solution test = new Solution();
//
//        int[] nums = {1,1,1};
//
//        test.subarraySum(nums, 2);
//    }
//}