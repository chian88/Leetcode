package RandomizedSet;
import java.util.*;

class RandomizedSet {
	Map<Integer, Integer> cache;
	List<Integer> cacheList;
	public RandomizedSet() {
		cache = new HashMap<>();
		cacheList = new ArrayList<>();
	}

	public boolean insert(int val) {
		if (cache.containsKey(val)) {
			return false;
		} else {
			cacheList.add(val);
			cache.put(val, cacheList.size() - 1);
			return true;
		}
	}

	public boolean remove(int val) {
		if (cache.containsKey(val)) {
			int originalIdx = cache.get(val);
			int lastidx = cacheList.size() - 1;

			cache.remove(val);
			if (lastidx != originalIdx) {
				cache.put(cacheList.get(lastidx), originalIdx);
			}

			cacheList.set(originalIdx, cacheList.get(lastidx));
			cacheList.remove(lastidx);
			return true;
		} else {
			return false;
		}
	}

	public int getRandom() {
		Random r = new Random();
		int randIdx = Math.abs(r.nextInt()) % cacheList.size();
		return cacheList.get(randIdx);
	}

	public static void main(String[] args) {
		RandomizedSet test = new RandomizedSet();
		test.remove(0);
		test.remove(0);
		test.insert(0);
		test.getRandom();
		test.remove(0);
		test.insert(0);
	test.getRandom();
	}
}

























//class RandomizedSet {
//	List<Integer> array;
//	Map<Integer, Integer> idxMap;
//
//	/** Initialize your data structure here. */
//	public RandomizedSet() {
//		array = new ArrayList<>();
//		idxMap = new HashMap<>();
//	}
//
//	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
//	public boolean insert(int val) {
//		if (idxMap.containsKey(val)) {
//			return false;
//		} else {
//			array.add(val);
//			idxMap.put(val, array.size() - 1);
//			return true;
//		}
//	}
//
//	/** Removes a value from the set. Returns true if the set contained the specified element. */
//	public boolean remove(int val) {
//		if (!idxMap.containsKey(val)) {
//			return false;
//		} else {
//			int swapidx = idxMap.get(val);
//			idxMap.remove(val);
//
//			int lastValue = array.get(array.size() - 1);
//			if (idxMap.containsKey(lastValue)) {
//				idxMap.put(lastValue, swapidx);
//			}
//
//
//			Collections.swap(array, swapidx, array.size() - 1);
//			array.remove(array.size() - 1);
//
//			return true;
//		}
//	}
//
//	/** Get a random element from the set. */
//	public int getRandom() {
//		Random rand = new Random();
//
//		int randIdx = rand.nextInt(array.size());
//		return array.get(randIdx);
//	}
//
//	public static void main(String[] args) {
//		RandomizedSet test = new RandomizedSet();
//		test.remove(0);
//		test.remove(0);
//		test.insert(0);
//		test.getRandom();
//		test.remove(0);
//		test.insert(0);
//	}
//
//}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */