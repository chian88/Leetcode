package CarFleet;
import java.util.*;

class Car {
	int position;
	int speed;

	Car(int position, int speed) {
		this.position = position;
		this.speed = speed;
	}
}

class Solution {
	public int carFleet(int target, int[] position, int[] speed) {
		if (position.length == 1) return 1;
		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < position.length; i++) {
			cars.add(new Car(position[i], speed[i]));
		}

		Collections.sort(cars, new Comparator<Car>() {
			@Override
			public int compare(Car o1, Car o2) {
				return Integer.compare(o1.position, o2.position);

			}
		});

		Deque<Double> stack = new ArrayDeque<>();

		for (int i = cars.size() - 1; i >= 0; i--) {
			Car c = cars.get(i);
			double arrivalTimes = (target - c.position) * 1.0 / c.speed;

			if (stack.isEmpty() || arrivalTimes > stack.peekFirst()) {
				stack.addFirst(arrivalTimes);
			}
		}


		return stack.size();
	}


	public static void main(String[] args) {
		Solution test = new Solution();
		test.carFleet(10, new int[]{6,8}, new int[]{3,2});
	}
}