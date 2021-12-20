package OpenTheLock;
import java.util.*;



class Solution {
	public int openLock(String[] deadends, String target) {
		Set<String> deadEndSet = new HashSet<>();
		for (String deadend : deadends) {
			deadEndSet.add(deadend);
		}

		Queue<String> q = new LinkedList<>();

		q.add("0000");
		int dist = 0;
		if (target.equals("0000")) {
			return dist;
		}
		if (deadEndSet.contains(target) || deadEndSet.contains("0000")) {
			return -1;
		}
		while (!q.isEmpty()) {
			int levelSize = q.size();

			while (levelSize > 0) {
				String curr = q.poll();

				List<String> candidates = generateNextString(curr);

				for (String candidate : candidates) {
					if (candidate.equals(target)) {
						return dist + 1;
					}

					if (!deadEndSet.contains(candidate)) {
						deadEndSet.add(candidate);
						q.add(candidate);
					}
				}

				levelSize--;
			}
			dist++;

		}
		return -1;
	}


	List<String> generateNextString(String curr) {

		List<String> res = new ArrayList<>();
		Map<Character, char[]> mapping = new HashMap<>();

		mapping.put('0', new char[]{'9', '1'});
		mapping.put('1', new char[]{'0', '2'});
		mapping.put('2', new char[]{'1', '3'});
		mapping.put('3', new char[]{'2', '4'});
		mapping.put('4', new char[]{'3', '5'});
		mapping.put('5', new char[]{'4', '6'});
		mapping.put('6', new char[]{'5', '7'});
		mapping.put('7', new char[]{'6', '8'});
		mapping.put('8', new char[]{'7', '9'});
		mapping.put('9', new char[]{'8', '0'});

		for (int i = 0; i < curr.length(); i++) {
			StringBuilder sb = new StringBuilder(curr);
			char[] possibles = mapping.get(curr.charAt(i));

			for (char possible : possibles) {
				sb.setCharAt(i, possible);
				res.add(sb.toString());
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.openLock(new String[]{"0000"}, "0202");
	}

}



















//
//class Solution {
//	public int openLock(String[] deadends, String target) {
//
//		HashSet<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));
//
//		HashSet<String> visited = new HashSet<>();
//
//		Queue<String> q = new LinkedList<>();
//
//		q.offer("0000");
//
//		visited.add("0000");
//
//		int level = 0;
//		while (!q.isEmpty()) {
//			int size = q.size();
//
//			while (size > 0) {
//
//				String curr = q.poll();
//
//				if (deadendsSet.contains(curr)) {
//					size--;
//					continue;
//				}
//
//				if (curr.equals(target)) {
//					return level;
//				}
//
//				for (int i = 0; i < 4; i++) {
//					StringBuilder sb = new StringBuilder(curr);
//
//					String up = sb.substring(0, i) + (sb.charAt(i) == '0' ? 9 : sb.charAt(i) - '0' - 1 ) + sb.substring(i + 1);
//					String down = sb.substring(0, i) + (sb.charAt(i) == '9' ? 0 : sb.charAt(i) - '0' + 1 ) + sb.substring(i + 1);
//
//					if (!visited.contains(up)) {
//						visited.add(up);
//						q.offer(up);
//					}
//
//					if (!visited.contains(down)) {
//						visited.add(down);
//						q.offer(down);
//					}
//
//				}
//
//				size--;
//			}
//
//			level++;
//		}
//
//
//
//		return -1;
//	}
//
//	public static void main(String[] args) {
//		Solution test = new Solution();
//		test.openLock(new String[]{"8888"}, "0009");
//	}
//}