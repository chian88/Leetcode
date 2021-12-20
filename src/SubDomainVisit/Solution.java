package SubDomainVisit;
import java.util.*;

class Solution {
	public static List<String> subdomainVisits(String[] cpdomains) {
		Map<String, Integer> counter = new HashMap<>();

		for (String cpdomain : cpdomains) {
			String[] arr = cpdomain.split(" ");
			int count = Integer.parseInt(arr[0]);

			String addresses = arr[1];

			for (int i = addresses.length() - 1; i >= 0; i--) {
				if (addresses.charAt(i) == '.') {
					String address = addresses.substring(i+1);

					counter.putIfAbsent(address, 0);
					counter.put(address, counter.get(address) + count);
				}
			}

			counter.putIfAbsent(addresses, 0);
			counter.put(addresses, counter.get(addresses) + count);
		}

		List<String> res = new ArrayList<>();

		for (Map.Entry<String, Integer> count : counter.entrySet()) {
			res.add(count.getValue() + " " + count.getKey());
		}

		return res;
	}

	public static void main(String[] args) {
		subdomainVisits(new String[] {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
	}
}