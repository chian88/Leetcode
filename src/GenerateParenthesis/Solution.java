package GenerateParenthesis;
import java.util.*;

class Solution {
	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();

		generateParenthesisHelper(n, n, "", result);
		return result;
	}

	static void generateParenthesisHelper(int leftParenNeeded , int rightParenNeeded,
								   String strSoFar, List<String> result) {

		if (rightParenNeeded == 0) {
			result.add(strSoFar);
			return;
		}

		if (leftParenNeeded > 0) {
			generateParenthesisHelper(leftParenNeeded - 1, rightParenNeeded,
					strSoFar + "(", result);
		}

		if (rightParenNeeded > leftParenNeeded) {
			generateParenthesisHelper(leftParenNeeded, rightParenNeeded - 1,
					strSoFar + ")", result);
		}
	}

	public static void main(String[] args) {
		generateParenthesis(2);
	}
}