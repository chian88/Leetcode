package Triangle;
import java.util.*;


// bottom up.
class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {


		List<Integer> prevRow = triangle.get(triangle.size() - 1);
		for (int i = triangle.size() - 2; i >= 0; i --) {
			List<Integer> row = triangle.get(i);
			List<Integer> newRow = new ArrayList<>();
			for (int j = 0; j < row.size(); j++) {
				int min = Math.min(prevRow.get(j), prevRow.get(j + 1));
				newRow.add(min + row.get(j));
			}

			if (i == 0) {
				return newRow.get(0);
			}
			prevRow = newRow;
		}
		return triangle.get(triangle.size() - 1).get(0);
	}

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3,4));
		triangle.add(Arrays.asList(6,5,7));
		triangle.add(Arrays.asList(4,1,8,3));
		Solution test = new Solution();
		test.minimumTotal(triangle);
	}
}