package AccountMerge;
import java.util.*;


class Solution {
	public static List<List<String>> accountsMerge(List<List<String>> accounts) {
		UnionFindStructure unionStructure = new UnionFindStructure();


		Map<String, String> emailToName = new HashMap<>();
		Map<String, Integer> emailToId = new HashMap<>();

		int id = 0;

		for (List<String> account : accounts) {
			String name = "";
			for (String email : account) {
				if (name.equals("")) {
					name = email;
					continue;
				}
				emailToName.put(email, name);

				if (!emailToId.containsKey(email)) {
					emailToId.put(email, id++);
				}
				unionStructure.union(emailToId.get(account.get(1)), emailToId.get(email));
			}
		}

		Map<Integer, List<String>> idxToEmailList = new HashMap<>();

		for (String email : emailToName.keySet()) {
			int idx = unionStructure.find(emailToId.get(email));
			idxToEmailList.computeIfAbsent(idx, x -> new ArrayList<>()).add(email);
		}


		for (List<String> emailList : idxToEmailList.values()) {
			Collections.sort(emailList);

			emailList.add(0, emailToName.get(emailList.get(0)));
		}

		return new ArrayList<>(idxToEmailList.values());
	}


}

class UnionFindStructure {
	int[] parent = new int[10001];

	UnionFindStructure() {
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}

	public int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}

		return parent[x];
	}

	public void union(int x, int y) {
		parent[find(x)] = find(y);
	}
}