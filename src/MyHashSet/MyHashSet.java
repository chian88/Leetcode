package MyHashSet;
import java.util.*;

class MyHashSet {
	int hash = 10_000;
	List<Integer>[] map;
	public MyHashSet() {
		map = new ArrayList[hash];
	}

	public void add(int key) {
		if (contains(key)) {
			return;
		}

		int hashed = key % hash;

		if (map[hashed] == null) {
			map[hashed] = new ArrayList<>();
		}

		map[hashed].add(key);
	}

	public void remove(int key) {
		int hashed = key % hash;

		if (map[hashed] == null) {
			return;
		}

		List<Integer> bucket = map[hashed];

		bucket.remove(Integer.valueOf(key));
	}

	public boolean contains(int key) {
		int hashed = key % hash;

		if (map[hashed] == null) {
			return false;
		}

		List<Integer> bucket = map[hashed];

		for (int i = 0; i < bucket.size(); i++) {
			if (bucket.get(i) == key) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		MyHashSet test = new MyHashSet();
		test.add(1);
		test.add(2);
		test.contains(1);
		test.contains(3);
		test.add(2);
		test.contains(2);
		test.remove(2);
		test.contains(2);
	}
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */