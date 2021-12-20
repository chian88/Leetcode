package MinTransfer;
import java.util.*;

class CycleStatus {
	boolean gotCycle;
	int minAmount;
	int to;
	int from;

	CycleStatus(boolean gotCycle, int minAmount, int to, int from){
		this.gotCycle = gotCycle;
		this.minAmount = minAmount;
		this.to = to;
		this.from = from;
	}
}


class Solution {
//	public int minTransfers(int[][] transactions) {
//		Map<Integer, List<int[]>> book = new HashMap<>();
//
//		for (int[] transaction : transactions) {
//			book.putIfAbsent(transaction[0], new ArrayList<>());
//			book.get(transaction[0]).add(new int[]{transaction[1], transaction[2]});
//
//		}
//
//		for (int person : book.keySet()) {
//			List<int[]> owings = book.get(person);
//
//			for (int[] owing : owings) {
//				CycleStatus candidate = detectCycle(book, person, owing[1], person);
//
//				if (candidate.gotCycle) {
//					deleteCycle(book, candidate, person);
//				}
//			}
//
//
//		}
//
//
//		return -1;
//	}
//
//	void deleteCycle(Map<Integer, List<int[]>> book , CycleStatus candidate, int person) {
//		List<int[]> owings = book.get(person);
//
//		for(int[] owing : owings) {
//			if (person == candidate.from && owing[0] == candidate.to ||
//				person == candidate.to && owing[0] == candidate.from) {
//				owing[]
//			}
//		}
//	}
//
//	CycleStatus detectCycle(Map<Integer, List<int[]>> book, int person, int min, int originalPerson) {
//		List<int[]> owings = book.get(person);
//
//		for (int[] owing : owings) {
//			if (owing[0] == originalPerson) {
//				// cycle detected
//				return new CycleStatus(true, Math.min(min, owing[1]), originalPerson, person);
//
//			} else {
//				CycleStatus candidate = detectCycle(book, owing[0], Math.min(min, owing[1]), originalPerson);
//				if (candidate.gotCycle) return candidate;
//			}
//		}
//
//		return new CycleStatus(false,  -1, originalPerson, person);
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.minTransfers(new int[][] {{0,1,10}, {1,0,1}, {1,2,5}, {2,0,5}});
//	}
}