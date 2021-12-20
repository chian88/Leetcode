package DesignALeaderboard;
import java.util.*;

class Player {
	int id;
	int score;

	Player(int id, int score) {
		this.id = id;
		this.score = score;
	}
}

class Leaderboard {
	PriorityQueue<Player> heap;
	HashMap<Integer, Player> map;

	public Leaderboard() {
		heap = new PriorityQueue<>(new Comparator<Player>() {
			@Override
			public int compare(Player o1, Player o2) {
				return o2.score - o1.score;
			}
		});

		map = new HashMap<>();
	}

	public void addScore(int playerId, int score) {
		if (map.containsKey(playerId)) {
			Player p = map.get(playerId);
			p.score += score;
			heap.remove(p);
			heap.add(p);
		} else {
			Player p = new Player(playerId, score);
			map.put(playerId, p);
			heap.add(p);
		}
	}

	public int top(int K) {
		int sum = 0;
		List<Player> collect = new LinkedList<>();
		while (K > 0) {
			Player p = heap.poll();
			sum += p.score;
			collect.add(p);
			K--;
		}

		while (collect.size() > 0) {
			heap.add(collect.remove(0));
		}

		return sum;
	}

	public void reset(int playerId) {
		Player p = map.get(playerId);
		map.remove(playerId);
		heap.remove(p);
	}

	public static void main(String[] args) {
		Leaderboard test = new Leaderboard();
//		test.addScore(1,82);
//		test.addScore(2,84);
//		test.addScore(3,47);
//		test.addScore(4,86);
//		test.addScore(5,92);
//		test.addScore(6,74);
//		test.addScore(7,34);
//		test.addScore(8,67);
//		test.addScore(9,76);
//		test.addScore(10,73);
//		test.top(4);
//		test.top(4);
//		test.top(8);
//		test.reset(1);
//		test.reset(2);

		test.addScore(1,13);
		test.addScore(2,93);
		test.addScore(3,84);
		test.addScore(4,6);
		test.addScore(5,89);
		test.addScore(6,31);
		test.addScore(7,7);
		test.addScore(8,1);
		test.addScore(9,98);
		test.addScore(10,42);
		test.top(5);
		test.reset(1);
		test.reset(2);
		test.addScore(3,76);
		test.addScore(4,68);
		test.top(1);
		test.reset(3);
		test.reset(4);
		test.addScore(2,70);
		test.reset(2);

	}
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */