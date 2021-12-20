package ShoppingOffers;
import java.util.*;

class Solution {
	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		Map<List<Integer>, Integer> dp = new HashMap<>();
		int ans = recurse(price, special, needs, dp);
		return ans;
	}

	int recurse(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> dp) {
		if (dp.containsKey(needs)) {
			return dp.get(needs);
		}

		boolean allNeedsFulfilled = true;
		for (int need : needs) {
			if (need > 0) {
				allNeedsFulfilled = false;
			}
		}

		if (allNeedsFulfilled) {
			return 0;
		}

		int ans = 0;

		// normal price.
		for(int i = 0; i < needs.size(); i++) {
			if (needs.get(i) == 0) {
				continue;
			}
			ans += needs.get(i) * price.get(i);
		}

		// special offers.

		for (int i = 0; i < special.size(); i++) {
			List<Integer> offer = special.get(i);
			boolean meetRequirement = true;
			List<Integer> newNeeds = new ArrayList<>(needs);
			for(int k = 0; k < offer.size() - 1; k++) {
				int itemToSell = offer.get(k);

				newNeeds.set(k, needs.get(k) - itemToSell);
				if (needs.get(k) < itemToSell) {
					meetRequirement = false;
				}
			}

			if (meetRequirement) {
				int offerPrice = offer.get(offer.size() - 1);
				ans = Math.min(ans, offerPrice + recurse(price, special, newNeeds, dp));
			}
		}


		dp.put(needs, ans);

		return ans;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		List<List<Integer>> special = new ArrayList<>();
		special.add(Arrays.asList(3,0,5));
		special.add(Arrays.asList(1,2,10));
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();

		a.add(1);
		b.add(1);
		test.shoppingOffers(Arrays.asList(2,5), special, Arrays.asList(3,2));
	}
}