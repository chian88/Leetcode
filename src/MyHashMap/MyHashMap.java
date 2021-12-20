package MyHashMap;
import java.util.*;

class Pair {
	int key;
	int value;

	Pair(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

class MyHashMap {
	int hash = 10_000;
	List<Pair>[] buckets;

	public MyHashMap() {
		buckets = new ArrayList[hash];
	}

	public void put(int key, int value) {
		int hashed = key % hash;
		if (buckets[hashed] == null) {
			buckets[hashed] = new ArrayList();
		}

		List<Pair> bucket = buckets[hashed];
		for (int i = 0; i < bucket.size(); i++) {
			if (bucket.get(i).key == key) {
				bucket.get(i).value = value;
				return;
			}
		}

		bucket.add(new Pair(key, value));
	}

	public int get(int key) {
		int hashed = key % hash;
		if (buckets[hashed] == null) {
			return -1;
		}

		List<Pair> bucket = buckets[hashed];
		for (int i = 0; i < bucket.size(); i++) {
			if (bucket.get(i).key == key) {

				return bucket.get(i).value;
			}
		}

		return -1;
	}

	public void remove(int key) {
		int hashed = key % hash;
		if (buckets[hashed] == null) {
			return;
		}

		List<Pair> bucket = buckets[hashed];
		for (int i = 0; i < bucket.size(); i++) {
			if (bucket.get(i).key == key) {
				bucket.remove(i);
			}
		}
	}
}
