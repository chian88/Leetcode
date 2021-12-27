package ThreeSum;
import java.util.*;

class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] > 0) {
				break;
			}

			if (i != 0 && nums[i - 1] == nums[i]) {
				continue;
			}

			int lo = i + 1;
			int hi = nums.length - 1;

			while (lo < hi) {

				int sum = nums[i] + nums[lo] + nums[hi];

				if (sum < 0) {
					lo++;
				} else if (sum > 0) {
					hi--;
				} else {
					res.add(new ArrayList<>(Arrays.asList(nums[i], nums[lo], nums[hi])));
					lo++;
					hi--;
					while (lo < hi && nums[lo] == nums[lo - 1])
						++lo;


				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.threeSum(new int[]{-1,0,1,2,-1,-4});
	}
}

//class Solution {
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//
//        Arrays.sort(nums);
//        Integer prev = null;
//
//        for (int i = 0; i < nums.length; i++) {
//            int current = nums[i];
//            if (current > 0) break;
//            if (prev != null && current == prev) continue;
//            result.addAll(twoSum(i+1, nums, current));
//            prev = current;
//        }
//
//        return result;
//    }
//
//    List<List<Integer>> twoSum(int left, int[] nums, int current) {
//        int right = nums.length - 1;
//        List<List<Integer>> result = new ArrayList<>();
//        Integer prev = null;
//        boolean justSwtichLeft = false;
//        boolean justSwitchRight = false;
//
//        while (left < right) {
//            int temp = current + nums[left] + nums[right];
//
//            if (justSwitchRight) {
//                if (prev != null && nums[right] == prev) {
//                    right--;
//                    continue;
//
//                }
//            }
//
//            if (justSwtichLeft) {
//                if (prev != null && nums[left] == prev) {
//                    left++;
//                    continue;
//                }
//            }
//
//            if (temp > 0) {
//                prev = nums[right];
//                right--;
//                justSwitchRight = true;
//                justSwtichLeft = false;
//            } else if (temp < 0) {
//                prev = nums[left];
//                left++;
//                justSwtichLeft = true;
//                justSwitchRight = false;
//            } else if (temp == 0) {
//                List<Integer> tempResult = new ArrayList<>();
//                tempResult.add(current);
//                tempResult.add(nums[left]);
//                tempResult.add(nums[right]);
//                result.add(tempResult);
//                prev = nums[left];
//                left++;
//                justSwtichLeft = true;
//                justSwitchRight = false;
//
//            }
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        Solution test = new Solution();
//        test.threeSum(new int[]{0,0,0, 0});
//    }
//}