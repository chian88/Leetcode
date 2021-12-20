package KeysAndRoom;
import java.util.*;

class Solution {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		boolean[] visited = new boolean[rooms.size()];

		Queue<Integer> q = new LinkedList<>();

		q.add(0);
		visited[0] = true;
		while (!q.isEmpty()) {
			int curr = q.poll();

			List<Integer> keys = rooms.get(curr);

			for (int key : keys) {
				if (!visited[key]) {
					visited[key] = true;
					q.add(key);
				}
			}
		}

		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == false) {
				return false;
			}
		}

		return true;
	}
}
















//class Solution {
//	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//		boolean[] visited = new boolean[rooms.size()];
//
//		Deque<Integer> q = new ArrayDeque<>();
//
//		q.addLast(0);
//		visited[0] = true;
//		while(!q.isEmpty()) {
//			int currRoom = q.pollFirst();
//
//			List<Integer> nextRooms = rooms.get(currRoom);
//
//			for (int nextRoom : nextRooms) {
//				if (!visited[nextRoom]) {
//					q.addLast(nextRoom);
//					visited[nextRoom] = true;
//				}
//			}
//		}
//
//		for (int i = 0; i < visited.length; i++) {
//			if (visited[i] == false) {
//				return false;
//			}
//		}
//
//		return true;
//	}
//}