package OptimalAccountBalancing;

import java.util.*;


public class Solution {
	public int minTransfers(int[][] transactions) {
		int[] debt = buildDebt(transactions);

		return getMinTransaction(0, debt);

	}

	int getMinTransaction(int curId, int[] debt) {
		while (curId < debt.length && debt[curId] == 0) {
			curId++;
		}

		if (curId == debt.length) {
			return 0;
		}

		int minTransaction = Integer.MAX_VALUE;

		for (int i = curId + 1; i < debt.length; i++) {
			if (debt[i] * debt[curId] < 0) {
				debt[i] += debt[curId];
				minTransaction = Math.min(minTransaction, getMinTransaction(curId + 1, debt) + 1);
				debt[i] -= debt[curId];
			}
		}

		return minTransaction;
	}

	int[] buildDebt(int[][] transactions) {
		Map<Integer, Integer> debtMap = new HashMap<>();

		for (int[] transaction : transactions) {
			debtMap.put(transaction[0], debtMap.getOrDefault(transaction[0], 0) + transaction[2]);
			debtMap.put(transaction[1], debtMap.getOrDefault(transaction[1], 0) - transaction[2]);
		}

		int[] debt = new int[debtMap.size()];
		int i = 0;

		for (int amount : debtMap.values()) {
			debt[i++] = amount;
		}

		return debt;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.minTransfers(new int[][]{{0, 1, 10}, {1,0, 1}, {1,2,5}, {2,0,5}});
	}
}
