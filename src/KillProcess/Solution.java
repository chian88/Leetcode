package KillProcess;
import java.util.*;

class Solution {
	Map<Integer, List<Integer>> graph;
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		graph = new HashMap<>();

		for (int i = 0; i < pid.size(); i++) {
			int parent = ppid.get(i);
			int itself = pid.get(i);

			graph.putIfAbsent(parent, new ArrayList<>());
			graph.get(parent).add(itself);
		}
		List<Integer> res = new ArrayList<>();
		dfs(kill, res);
		return res;
	}

	void dfs(int curr, List<Integer> res) {

		res.add(curr);

		List<Integer> nexts = graph.get(curr);

		if (nexts == null) {
			return;
		}

		for (int next : nexts) {
			dfs(next, res);
		}
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.killProcess(Arrays.asList(1,3,10,5), Arrays.asList(3,0,5,3), 5);
	}

}