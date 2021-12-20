package ProcessTasksUsingServers;
import java.util.*;
class Solution {
	public int[] assignTasks(int[] servers, int[] tasks) {
		// int[] {weight, index}
		PriorityQueue<int[]> freeServers = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int weightCmp = Integer.compare(o1[0], o2[0]);

				if (weightCmp != 0) {
					return weightCmp;
				}

				return Integer.compare(o1[1], o2[1]);
			}
		});
		// int[] {busytime, index}
		PriorityQueue<int[]> busyServers = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int busyCmp = Integer.compare(o1[0], o2[0]);

				if (busyCmp != 0) {
					return busyCmp;
				}

				return Integer.compare(o1[1], o2[1]);

			}
		});
		for (int i = 0; i < servers.length; i++) {
			freeServers.add(new int[]{servers[i], i});
		}

		int[] res = new int[tasks.length];
		int time = 0;
		for (int i = 0; i < tasks.length; i++) {
			time = Math.max(time, i);

			if (freeServers.isEmpty()) {
				time = busyServers.poll()[0];
			}
			while (!busyServers.isEmpty() && busyServers.peek()[0] <= time) {
				int[] busyServer = busyServers.poll();
				freeServers.add(new int[]{servers[busyServer[1]], busyServer[1]});
			}

			int[] toUseServer = freeServers.poll();

			res[i] = toUseServer[1];
			busyServers.add(new int[]{ time + tasks[i], toUseServer[1]});

		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.assignTasks(new int[]{10,63,95,16,85,57,83,95,6,29,71}, new int[]{70,31,83,15,32,67,98,65,56,48,38,90,5});
	}
}
//[8,0,3,9,5,1,10,6,4,2,7,9,0]