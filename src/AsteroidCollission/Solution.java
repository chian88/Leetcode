package AsteroidCollission;
import java.util.*;


class Solution {
	public static int[] asteroidCollision(int[] asteroids) {
		Deque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < asteroids.length; i++) {
			int currAstroid = asteroids[i];
			if (stack.isEmpty() || currAstroid > 0) {
				stack.addFirst(currAstroid);
			} else {
				boolean selfDestruct = false;
				while (!stack.isEmpty()) {
					int prevAsteroid = stack.peekFirst();

					if (prevAsteroid < 0) {
						stack.addFirst(currAstroid);
						break;
					} else {
						if (Math.abs(prevAsteroid) < Math.abs(currAstroid)) {
							stack.removeFirst();

						} else if (Math.abs(prevAsteroid) == Math.abs(currAstroid)) {
							selfDestruct = true;
							stack.removeFirst();
							break;
						} else {
							break;
						}
					}

				}

				if (!selfDestruct && stack.isEmpty()) {
					stack.addFirst(currAstroid);
				}

			}
		}

		int[] result = new int[stack.size()];
		int i = 0;
		while (!stack.isEmpty()) {
			result[i] = stack.removeLast();
			i++;
		}
		return result;
	}

	public static void main(String[] args) {
		asteroidCollision(new int[]{5,10,-5});
	}
}