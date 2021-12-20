package MinimumGeneticMutation;
import java.util.*;

class Solution {
	public int minMutation(String start, String end, String[] bank) {
		Queue<String> q = new LinkedList<>();
		if (start.equals(end)) {
			return 0;
		}
		q.add(start);
		int dist = 0;
		Set<String> visited = new HashSet<>();
		while (!q.isEmpty()) {
			int levelSize = q.size();

			while (levelSize > 0) {
				String curr = q.poll();

				List<String> nexts = generateNext(curr, bank);
				if (nexts == null) {
					continue;
				}

				for (String next : nexts) {
					if (next.equals(end)) {
						return dist + 1;
					}

					if (!visited.contains(next)) {
						visited.add(next);
						q.add(next);
					}
				}

				levelSize--;
			}

			dist++;
		}

		return -1;
	}

	List<String> generateNext(String curr, String[] bank) {

		List<String> res = new ArrayList<>();
		for (String candidate : bank) {
			int changes = 0;
			for (int i = 0; i < curr.length(); i++) {
				if (curr.charAt(i) != candidate.charAt(i)) {
					changes++;
				}
			}

			if (changes == 1) {
				res.add(candidate);
			}
		}

		return res;
	}
}