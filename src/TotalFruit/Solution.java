package TotalFruit;
import java.util.*;


class Solution {
	public int totalFruit(int[] fruits) {
		Map<Integer, Integer> typeCount = new HashMap<>();

		int start = 0;
		int end = 0;

		int maxFruitsCollected = 0;

		typeCount.put(fruits[0], 1);

		while (end < fruits.length) {
			if (typeCount.size() <= 2) {
				// meet requirement.

				maxFruitsCollected = Math.max(end - start + 1, maxFruitsCollected);
				end ++ ;
				if (end == fruits.length) {
					break;
				}
				typeCount.put(fruits[end], typeCount.getOrDefault(fruits[end], 0) + 1 );

			} else {
				typeCount.put(fruits[start], typeCount.get(fruits[start]) - 1);
				if (typeCount.get(fruits[start]) == 0) {
					typeCount.remove(fruits[start]);
				}
				start++;
			}
		}

		return maxFruitsCollected ;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4});

	}
}