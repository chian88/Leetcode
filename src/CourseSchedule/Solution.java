package CourseSchedule;
import java.util.*;


class Solution {
	HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		for (int [] prerequisite : prerequisites) {
			if (adjacencyList.containsKey(prerequisite[1])) {
				adjacencyList.get(prerequisite[1]).add(prerequisite[0]);
			} else {
				List<Integer> ls = new ArrayList<>();
				ls.add(prerequisite[0]);
				adjacencyList.put(prerequisite[1], ls);
			}
		}
		boolean[] bitMap = new boolean[numCourses];

		for (int i = 0; i < numCourses; i++) {
			boolean foundCycle = findCycle(adjacencyList, i, new HashSet<>(), bitMap);
			if(foundCycle) return false;
		}

		return true;
	}

	private boolean findCycle(HashMap<Integer, List<Integer>> adjacencyList, int courseNum,
							  Set<Integer> chain, boolean[] bitMap) {

		if (chain.contains(courseNum)) return true;
		if (bitMap[courseNum]) return false;
		chain.add(courseNum);

		List<Integer> nextCourses = adjacencyList.get(courseNum);

		if (nextCourses == null) {
			chain.remove(courseNum);
			return false;
		}

		for (int nextCourse : nextCourses) {
			boolean res = findCycle(adjacencyList, nextCourse, chain, bitMap);
			if (res) return true;
		}
		bitMap[courseNum] = true;
		chain.remove(courseNum);

		return false;

	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.canFinish(6, new int[][]{{1,4}, {2,4}, {3,1}, {3,2}, {5, 1}} );
	}


}