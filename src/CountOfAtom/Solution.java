package CountOfAtom;
import java.util.*;

class Chemical {
	String name;
	int count;

	Chemical(String name, int count) {
		this.name = name;
		this.count = count;
	}
}

class Solution {
	public String countOfAtoms(String formula) {
		Deque<HashMap<String, Integer>> stack = new ArrayDeque<>();

		for (int i = 0; i < formula.length(); i++) {
			char c = formula.charAt(i);

			if (c == '(') {
				i = extractChem(formula, i + 1, stack, true);
			} else if (c == ')') {
				StringBuilder multiplier = new StringBuilder();
				i++;
				while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
					multiplier.append(formula.charAt(i));
					i++;
				}

				HashMap<String, Integer> chemMap = stack.poll();
				if (multiplier.length() > 0) {
					multiply(chemMap, Integer.parseInt(multiplier.toString()));
				}

				if (!stack.isEmpty()) {
					mergeStack(chemMap, stack);
				} else {
					stack.addFirst(chemMap);
				}
				i--;

			} else {
				i = extractChem(formula, i, stack, false);

			}
		}

		while (stack.size() > 1) {
			HashMap<String, Integer> chemMap = stack.poll();
			mergeStack(chemMap, stack);
		}
		HashMap<String, Integer> chemMap = stack.poll();
		List<Chemical> res = new ArrayList<>();

		for (Map.Entry<String, Integer> chemMapEntry : chemMap.entrySet()) {
			res.add(new Chemical(chemMapEntry.getKey(), chemMapEntry.getValue()));
		}

		Collections.sort(res, (c1, c2) -> {
			return c1.name.compareTo(c2.name);
		});

		StringBuilder ans = new StringBuilder();

		for (int i = 0; i < res.size(); i++) {
			Chemical chem = res.get(i);

			if (chem.count > 1) {
				ans.append(chem.name);
				ans.append(chem.count);
			} else {
				ans.append(chem.name);
			}
		}

		return ans.toString();
	}

	void mergeStack(HashMap<String, Integer> chemMap, Deque<HashMap<String, Integer>> stack) {
		HashMap<String, Integer> targetMap = stack.poll();

		for (Map.Entry<String, Integer> chemMapEntry : chemMap.entrySet()) {
			if (targetMap.containsKey(chemMapEntry.getKey())) {
				targetMap.put(chemMapEntry.getKey(),  targetMap.get(chemMapEntry.getKey()) + chemMapEntry.getValue());
			} else {
				targetMap.put(chemMapEntry.getKey(), chemMapEntry.getValue());
			}
		}

		stack.addFirst(targetMap);
	}

	void multiply(HashMap<String, Integer> chemMap, int multiplier) {
		for (String chem : chemMap.keySet()) {
			chemMap.put(chem, chemMap.get(chem) * multiplier);
		}
	}




	int extractChem(String formula, int i, Deque<HashMap<String, Integer>> stack, boolean createNewStack) {

		HashMap<String, Integer> chemMap = new HashMap<>();

		if (!createNewStack && !stack.isEmpty()) {
			chemMap = stack.poll();
		}

		while (i < formula.length() && (formula.charAt(i) != '(' && formula.charAt(i) != ')') ) {
			StringBuilder chemFormula = new StringBuilder();
			if (i < formula.length() && (Character.isLetter(formula.charAt(i)) && Character.isUpperCase(formula.charAt(i))) ) {
				chemFormula.append(formula.charAt(i));
				i++;
			}

			while (i < formula.length() && (Character.isLetter(formula.charAt(i)) && Character.isLowerCase(formula.charAt(i)) )) {
				chemFormula.append(formula.charAt(i));
				i++;
			}
			StringBuilder chemCount = new StringBuilder();
			while( i < formula.length() && Character.isDigit(formula.charAt(i))) {
				chemCount.append(formula.charAt(i));
				i++;
			}

			if (chemCount.length() == 0) {
				chemCount.append("1");
			}
			if (chemFormula.length() > 0) {
				if (chemMap.containsKey(chemFormula.toString())) {
					chemMap.put(chemFormula.toString(), chemMap.get(chemFormula.toString()) + Integer.parseInt(chemCount.toString()));
				} else {
					chemMap.put(chemFormula.toString(), Integer.parseInt(chemCount.toString()));
				}

			}

		}

		stack.addFirst(chemMap);
		return i - 1;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.countOfAtoms("((N7Li31C7B10Be37B23H2H11Li40Be15)26(OBLi48B46N4)25(O48C22He)2N10O34N15B33Li39H34H26B15B23C31(C36N38O33Li38H15H46He21Be38B50)8)3");
	}
}