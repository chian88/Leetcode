package FindTheCelebrity;

import java.util.*;

class Relation {
	boolean knows(int a, int b) {
		return true;
	}
}

public class Solution extends Relation {
	public int findCelebrity(int n) {
		List<Integer> celebrities = new ArrayList<>();

		for (int j = 0; j < n; j++) {
			if (knows(0, j)) {
				celebrities.add(j);
			}
		}

		for (int i = 1; i < n; i++) {
			List<Integer> knows = new ArrayList<>();
			for (int j = 0; j < celebrities.size(); j++) {
				int potential = celebrities.get(j);
				if (knows(i, potential)) {
					knows.add(potential);
				}
			}
			celebrities.retainAll(knows);
		}
		
		if (celebrities.isEmpty()) {
			return -1;
		}
		
		for (int celebrity : celebrities) {
			boolean knowSomeone = false;
			for (int j = 0; j < n; j++) {
				if (j == celebrity) {
					continue;
				}

				if (knows(celebrity, j)) {
					knowSomeone = true;
				}
			}
			if (!knowSomeone) {
				return celebrity;
			}
		}
		
		return -1;
	}
}