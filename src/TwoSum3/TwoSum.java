package TwoSum3;
import java.util.*;


class TwoSum {

	Map<Integer, List<Integer>> mapValToId;
	List<Integer> val;
	int id;

	public TwoSum() {
		mapValToId = new HashMap<>();
		val = new ArrayList<>();
		id = 0;
	}

	public void add(int number) {
		val.add(number);
		if (!mapValToId.containsKey(number)) {
			mapValToId.put(number, new ArrayList<>());
		}
		mapValToId.get(number).add(id);
		id++;

	}

	public boolean find(int value) {
		for (int i = 0; i < val.size(); i++) {
			int num = val.get(i);
			int target = value - num;
			List<Integer> candidates = mapValToId.get(target);

			if (candidates == null) {
				continue;
			}

			for (int candidate : candidates) {
				if (candidate != i) {
					return true;
				}
			}
		}

		return false;
	}
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */