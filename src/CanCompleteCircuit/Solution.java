package CanCompleteCircuit;
import java.util.*;


class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int totalGas = 0;
		int usedGas = 0;

		for (int i = 0; i < gas.length; i++) {
			totalGas += gas[i];
		}

		for (int i = 0; i < cost.length; i++) {
			usedGas += cost[i];
		}

		if (totalGas < usedGas) return -1;

		int[] remainingAtStart = new int[gas.length];

		int gasLeft = 0;
		for (int i = 0; i < gas.length; i++) {
			remainingAtStart[i] = gasLeft;
			gasLeft += gas[i];
			gasLeft -= cost[i];

		}

		int minGas = 0;
		int minGasIdx = 0;

		for (int i = 0; i < remainingAtStart.length; i++) {
			if (remainingAtStart[i] < minGas) {
				minGas = remainingAtStart[i];
				minGasIdx = i;
			}
		}

		return minGasIdx;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2});
	}
}