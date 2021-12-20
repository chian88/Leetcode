package DifferentWaysToAddParenthesis;
import java.util.*;
import java.util.stream.Collectors;


class Solution {
	public List<Integer> diffWaysToCompute(String expression) {

		expression = expression.replaceAll("-", "~-~");
		expression = expression.replaceAll("\\+", "~+~");
		expression = expression.replaceAll("\\*", "~*~");

		String[] tokens = expression.split("~");
		int numsCounts = (int) Math.ceil(tokens.length / 2.0);
		List<Integer>[][] dp = new List[numsCounts][numsCounts];


		List<Integer> answer = recurse(tokens, 0, tokens.length - 1, dp);

		return answer;
	}

	List<Integer> recurse(String[] tokens, int start, int end, List<Integer>[][] dp) {
		int numOfOperEnd = (int) Math.floor(end / 2.0);
		int numOfOperStart = (int) Math.floor(start / 2.0);
		if (dp[start - numOfOperStart][end - numOfOperEnd] != null) {
			return dp[start - numOfOperStart][end - numOfOperEnd];
		}
		if (start == end) {
			List<Integer> ans = new ArrayList<>();
			ans.add(Integer.parseInt(tokens[start]));
			dp[start - numOfOperStart][end - numOfOperEnd] = ans;
			return ans;
		}
		List<Integer> answers = new ArrayList<>();
		for (int i = start; i <= end - 2; i += 2) {
			List<Integer> ans1s = recurse(tokens, start, i, dp);
			List<Integer> ans2s = recurse(tokens, i + 2, end, dp);

			for (int ans1 : ans1s) {
				for (int ans2 : ans2s) {
					if (tokens[i + 1].equals("+")) {
						answers.add(ans1 + ans2);
					} else if (tokens[i + 1].equals("*")) {
						answers.add(ans1 * ans2);
					} else if (tokens[i + 1].equals("-")) {
						answers.add(ans1 - ans2);
					}

				}
			}
		}
		dp[start - numOfOperStart][end - numOfOperEnd] = answers;
		return answers;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.diffWaysToCompute("2*3-4*5");
	}


}