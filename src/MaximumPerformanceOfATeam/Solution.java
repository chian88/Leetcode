package MaximumPerformanceOfATeam;
import java.util.*;

class Engineer {
	int speed;
	int efficiency;

	Engineer(int speed, int efficiency) {
		this.speed = speed;
		this.efficiency = efficiency;
	}
}

class Solution {
	public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
		int MOD = (int) Math.pow(10, 9) + 7;
		List<Engineer> engineers = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			engineers.add(new Engineer(speed[i], efficiency[i]));
		}

		Collections.sort(engineers, new Comparator<Engineer>() {
			@Override
			public int compare(Engineer o1, Engineer o2) {
				return o2.efficiency - o1.efficiency;
			}
		});

		PriorityQueue<Engineer> heap = new PriorityQueue<>( new Comparator<Engineer>() {
			public int compare(Engineer o1, Engineer o2) {
				return o1.speed - o2.speed;
			}
		});
		long speedSum = 0;


		long res = 0;
		for (int i = 0; i < n; i++) {
			if (heap.size() > k - 1) {
				speedSum -= heap.poll().speed;
			}


			speedSum = (speedSum + engineers.get(i).speed);
			heap.add(engineers.get(i));
			res = Math.max(res,  speedSum * engineers.get(i).efficiency  );

		}

		return (int) (res % MOD);
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.maxPerformance(3, new int[]{2,8,2}, new int[]{2, 7, 1}, 2);
	}
}