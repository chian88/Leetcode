package ExclusiveTimeOfFunction;
import java.util.*;


class Solution {
	public int[] exclusiveTime(int n, List<String> logs) {
		int[] res = new int[n];

		Deque<String[]> stack = new ArrayDeque<>();

		for (int i = 0; i < logs.size(); i++) {
			String[] currLog = logs.get(i).split(":");
			if (i == 0) {
				stack.addFirst(currLog);
				continue;
			}
			String[] prevLog = logs.get(i - 1).split(":");

			if (currLog[1].equals("start") && prevLog[1].equals("start")) {
				// need to stop previous Start
				int end = Integer.parseInt(currLog[2]);
				int start = Integer.parseInt(prevLog[2]);
				int duration = end - start;
				res[Integer.parseInt(prevLog[0])] += duration;
				stack.addFirst(currLog);

			} else if (currLog[1].equals("end") && prevLog[1].equals("start")) {
				// just stop prev start.
				int end = Integer.parseInt(currLog[2]);
				int start = Integer.parseInt(prevLog[2]);
				int duration = end - start + 1;
				res[Integer.parseInt(prevLog[0])] += duration;
				stack.pollFirst();
			} else if (currLog[1].equals("end") && prevLog[1].equals("end")) {
				int end = Integer.parseInt(currLog[2]);
				int start = Integer.parseInt(prevLog[2]);
				int duration = end - start;
				res[Integer.parseInt(currLog[0])] += duration;
				stack.pollFirst();
			} else if (currLog[1].equals("start") && prevLog[1].equals("end")) {
				if (!stack.isEmpty()) {
					String[] stackPrevLog = stack.peekFirst();

					int end = Integer.parseInt(currLog[2]) - 1;
					int start = Integer.parseInt(prevLog[2]) + 1;
					int duration = end - start + 1;
					res[Integer.parseInt(stackPrevLog[0])] += duration;

					stack.addFirst(currLog);
				}
			}


		}

		return res;
	}
	public static void main(String[] args) {
		Solution test = new Solution();
		test.exclusiveTime(2, List.of(new String[]{"0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"}));
	}
}