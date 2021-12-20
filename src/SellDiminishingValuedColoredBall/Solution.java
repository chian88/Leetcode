package SellDiminishingValuedColoredBall;
import java.util.*;

class Solution {
	public int maxProfit(int[] inventory, int orders) {
		int MOD = 1_000_000_007;
		int n = inventory.length;
		long res = 0;
//		Integer[] inv = Arrays.stream(inventory).boxed().toArray(Integer[]::new);
//		Arrays.sort(inv, Collections.reverseOrder());
		Arrays.sort(inventory);

		for (int i = n - 1; i >= 0; i--) {
			long diff = inventory[i] - (i > 0 ? inventory[i - 1] : 0);
			long x = Math.min( orders, (n - i) * diff);
			long r = inventory[i];
			long l = r - x / (n - i);
			res += (r * (r + 1) / 2 - l * (l + 1) / 2) * (n - i);
			res %= MOD;
			res += l * (x % (n -i));
			res %= MOD;
			orders -= x;
		}
		return (int) res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxProfit(new int[]{1,2,3,6,7,9}, 40);
	}
}