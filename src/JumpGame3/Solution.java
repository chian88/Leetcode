package JumpGame3;
import java.util.*;

class Solution {
	public boolean canReach(int[] arr, int start) {
		boolean[] visited = new boolean[arr.length];

		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		if (arr[start] == 0) {
			return true;
		}
		visited[start] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();

			int left = curr - arr[curr];
			int right = curr + arr[curr];

			if (left >= 0 && arr[left] == 0 ) {
				return true;
			}

			if (right < arr.length && arr[right] == 0) {
				return true;
			}

			if (left >= 0 && !visited[left]) {
				visited[left] = true;
				q.add(left);
			}

			if (right < arr.length && !visited[right]) {
				visited[right] = true;
				q.add(right);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.canReach(new int[]{4,2,3,0,3,1,2}, 5);
	}
}