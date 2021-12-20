package EvaluateDivision;
import java.util.*;

class Solution {
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		double[] output = new double[queries.size()];
		Set<String> known = new HashSet<>();
		for (List<String> equation : equations) {
			known.add(equation.get(0));
			known.add(equation.get(1));
		}
		for (int i = 0; i < queries.size(); i++) {
			List<String> query = queries.get(i);
			Set<Integer> visited = new HashSet<>();
			if (!known.contains(query.get(0))) {
				output[i] = -1.0;
				continue;
			}

			if (!known.contains(query.get(1))) {
				output[i] = -1.0;
				continue;
			}

			if (query.get(0).equals(query.get(1))) {
				output[i] = 1.0;
				continue;
			}
			double ans = dfs(equations, values, query.get(0), query.get(1), 1.0, visited);
			output[i] = ans;
		}
		return output;
	}

	double dfs(List<List<String>> equations, double[] values, String src, String dest, double num, Set<Integer> visited) {
		double ans = -1.0;
		for (int i = 0; i < equations.size(); i++) {
			List<String> equation = equations.get(i);

			if (visited.contains(i)) {
				continue;
			}

			visited.add(i);

			if (equation.get(0).equals(dest) && equation.get(1).equals(src)) {
				return num / values[i];
			}
			if (equation.get(1).equals(dest) && equation.get(0).equals(src)) {
				return num * values[i];
			}
			if (equation.get(0).equals(src)) {

				ans = dfs(equations, values, equation.get(1), dest, num * values[i], visited);
				if (ans != -1.0) {
					return ans;
				}

			}
			if (equation.get(1).equals(src)) {
				ans = dfs(equations, values, equation.get(0), dest, num / values[i], visited);

				if (ans != -1.0) {
					return ans;
				}

			}

			visited.remove(i);
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		List<List<String>> equations = new ArrayList<>();
		equations.add(Arrays.asList("a", "b"));
		equations.add(Arrays.asList("b", "c"));
		double[] values = new double[]{2.0, 3.0};
		List<List<String>> queries = new ArrayList<>();
		queries.add(Arrays.asList("a", "c"));
		queries.add(Arrays.asList("b", "a"));
		queries.add(Arrays.asList("a", "e"));
		queries.add(Arrays.asList("a", "a"));
		queries.add(Arrays.asList("x", "x"));
		test.calcEquation(equations, values, queries);
	}
}
//}[["x1","x2"],["x2","x3"],["x3","x4"],["x4","x5"]]
//		[3.0,4.0,5.0,6.0]
//		[["x1","x5"],["x5","x2"],["x2","x4"],["x2","x2"],["x2","x9"],["x9","x9"]]