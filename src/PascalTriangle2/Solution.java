package PascalTriangle2;
import java.util.*;


// recursion.

class Solution {
	int rowIndex ;
	public List<Integer> getRow(int rowIndex) {
		if (rowIndex == 0) {
			return new ArrayList<>(Arrays.asList(1));
		}

		if (rowIndex == 1) {
			return new ArrayList<>(Arrays.asList(1,1));
		}

		this.rowIndex = rowIndex;
		List<Integer> ans =  recursion(2, new ArrayList<>(Arrays.asList(1,1)));
		return ans;
	}

	List<Integer> recursion(int currIndex, List<Integer> prev) {


		List<Integer> nextRow = new ArrayList<>();

		for (int i = 0; i <= currIndex; i++) {
			if (i == 0 || i == currIndex) {
				nextRow.add(1);
			} else {
				nextRow.add(prev.get(i) + prev.get(i - 1));
			}
		}

		if (currIndex == rowIndex) {
			return nextRow;
		}

		return recursion(currIndex + 1, nextRow);
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.getRow(4);
	}
}

// loop
//class Solution {
//	public List<Integer> getRow(int rowIndex) {
//		if (rowIndex == 0) {
//			return Arrays.asList(1);
//		}
//
//		if (rowIndex == 1) {
//			return Arrays.asList(1, 1);
//		}
//
//
//		List<Integer> prev = Arrays.asList(1,1);
//		List<Integer> res = new ArrayList<>();
//		int col = 3;
//		while (rowIndex >= 2) {
//			for (int i = 0; i < col; i++) {
//				if (i == 0 || i == col - 1) {
//					res.add(1);
//				} else {
//					res.add(prev.get(i) + prev.get(i - 1));
//				}
//
//
//			}
//			prev = res;
//			col++;
//			res = new ArrayList<>();
//			rowIndex--;
//		}
//		return prev;
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.getRow(3);
//	}
//}