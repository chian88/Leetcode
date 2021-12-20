package ValidMountainArray;
import java.util.*;

class Solution {
	public boolean validMountainArray(int[] arr) {
		if (arr.length <= 2) {
			return false;
		}
		int left = 0;
		int right = 0;
		boolean goingUp = true;
		boolean firstSwitch = true;
		for (int i = 0; i < arr.length - 1; i++) {
			if (goingUp) {
				if (arr[i] > arr[i + 1] && firstSwitch) {
					firstSwitch = false;
					goingUp = false;
					right++;
				} else if (arr[i] == arr[i + 1]) {
					return false;
				} else {
					left++;
				}
			} else {
				if (arr[i] < arr[i + 1]) {
					return false;
				} else if (arr[i] > arr[i + 1]) {
					right++;
				} else {
					return false;
				}
			}

		}

		return left > 0 && right > 0;
	}
}