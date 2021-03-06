package LargestNumber;
import java.util.*;


class Solution {
	private class LargestNumberComparator implements Comparator<String> {

		@Override
		public int compare(String a, String b) {
			String order1 = a + b;
			String order2 = b + a;
			return order2.compareTo(order1);

		}
	}

	public String largestNumber(int[] nums) {
		String[] numbers = new String[nums.length];

		for (int i = 0; i < nums.length; i++) {
			numbers[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(numbers, new LargestNumberComparator());

		if (numbers[0].equals("0")) {
			return "0";
		}

		StringBuilder largestNumberStr= new StringBuilder();
		for (String number : numbers) {
			largestNumberStr.append(number);
		}

		return largestNumberStr.toString();
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.largestNumber(new int[]{3,30,34,5,9});
	}
}