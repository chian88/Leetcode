package CourseSchedule2;
import java.util.*;


class Solution {
	public static int[] findOrder(int numCourses, int[][] prerequisites) {

		Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

		for (int i = 0; i < prerequisites.length; i++) {
			int[] prerequisite = prerequisites[i];
			List<Integer> existing = adjacencyList.get(prerequisite[1]);
			if (existing == null) {
				existing = new ArrayList<>();

			}

			existing.add(prerequisite[0]);
			adjacencyList.put(prerequisite[1], existing);
		}
		Deque<Integer> stack = new ArrayDeque<>();
		Set<Integer> visited = new HashSet<>();
		boolean cycle = false;
		for (int i = 0 ; i < numCourses; i++) {
			if (!visited.contains(i)) {
				cycle = findOrderHelper(adjacencyList, i, stack, new HashSet<>(), visited);
				if (cycle) {
					return new int[]{};
				}
			}


		}
		int[] result = stack.stream().mapToInt(Integer::intValue).toArray();

		return result;
	}

	static boolean findOrderHelper(Map<Integer, List<Integer>> adjacencyList, int current,
								   Deque<Integer> stack, Set<Integer> trail,
								   Set<Integer> visited) {
		List<Integer> nextNodes = adjacencyList.get(current);
		if (trail.contains(current)) return true;
		trail.add(current);
		for (int i = 0 ; nextNodes != null && i < nextNodes.size(); i++) {
			int nextNode = nextNodes.get(i);
			if (!visited.contains(nextNode)) {
				if (findOrderHelper(adjacencyList, nextNode, stack, trail, visited)) return true;
			}

		}
		stack.addFirst(current);
		visited.add(current);
		return false;
	}


	public static void main(String[] args) {
		findOrder(2, new int[][] {{1,0}});
	}
}