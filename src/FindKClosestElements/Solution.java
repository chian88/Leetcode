package FindKClosestElements;
import java.util.*;

class Solution {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {

		int left = 0;
		int right = arr.length;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] >= x) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}


		left -= 1;
		right = left + 1;

		while ( right - left - 1 < k) {
			if (left == -1) {
				right += 1;
				continue;
			}

			if (right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
				left -= 1;
			} else {
				right += 1;
			}
		}

		List<Integer> res = new ArrayList<>();
		for (int i = left + 1; i < right; i++) {
			res.add(arr[i]);
		}

		return res;
	}



	public static void main(String[] args) {
		Solution test = new Solution();
		test.findClosestElements(new int[]{0,1,1,1,2,3,6,7,8,9}, 9, 4);
	}
}