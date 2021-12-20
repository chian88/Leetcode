package SimplifyPath;
import java.util.*;

class Solution {
	public String simplifyPath(String path) {
		Deque<String> stack = new ArrayDeque<>();
		List<String> directories = new ArrayList<>();
		String[] paths = path.split("/+");


		for (int i = 0; i < paths.length; i++) {
			if (paths[i].equals(".")) {
				continue;
			} else if (paths[i].equals("..")) {
				if (stack.size() > 0) {
					stack.pollFirst();
				}

			} else if (paths[i].length() > 0) {
				stack.addFirst(paths[i]);
			}
		}

		StringBuilder res = new StringBuilder();
		res.append("/");
		while (!stack.isEmpty()) {
			res.append(stack.pollLast());
			res.append("/");
		}

		if (res.length() > 1 && res.charAt(res.length() - 1) == '/') {
			res.deleteCharAt(res.length() - 1);
		}

		return res.toString();
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.simplifyPath("/a/./b/../../c/");
	}
}