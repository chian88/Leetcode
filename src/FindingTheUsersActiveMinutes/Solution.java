package FindingTheUsersActiveMinutes;
import java.util.*;

class Solution {
	public int[] findingUsersActiveMinutes(int[][] logs, int k) {
		Map<Integer, Set<Integer>> userToMinutes = new HashMap<>();

		for (int[] log : logs) {
			userToMinutes.putIfAbsent(log[0], new HashSet<>());
			userToMinutes.get(log[0]).add(log[1]);
		}

		int[] ans = new int[k];

		for (Map.Entry<Integer, Set<Integer>> entry : userToMinutes.entrySet()) {
			ans[entry.getValue().size() - 1]++;
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.findingUsersActiveMinutes(new int[][]{{0,5}, {1,2}, {0,2}, {0,5}, {1,3}}, 5);
	}
}