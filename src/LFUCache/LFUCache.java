package LFUCache;
import java.util.*;

class Node {
	int key;
	int value;
	int freq;
	Node next;
	Node prev;

	Node() {

	}

	Node(int key, int value, int freq) {
		this.key = key;
		this.value = value;
		this.freq = freq;
	}
}

class DoubleLinkedList {
	Node head;
	Node tail;
	int size;

	DoubleLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
		this.size = 0;
	}

	Node removeFromTail() {
		Node ans = tail.prev;
		if (ans != head) {
			tail.prev = ans.prev;
			ans.prev.next = tail;
			size--;
		}

		return ans;
	}

	void removeFromList(Node node) {
		detachNode(node);
		size--;
	}

	void addToHead(Node node) {
		Node next = head.next;
		head.next = node;
		node.prev = head;
		node.next = next;
		size++;
		next.prev = node;
	}


	void detachNode(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
}

class LFUCache {

	Map<Integer, DoubleLinkedList> freqList;
	Map<Integer, Node> keyMap;
	int capacity;
	int minFreq;
	int size;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.minFreq = 0;
		freqList = new HashMap<>();
		keyMap = new HashMap<>();
	}

	public int get(int key) {
		if (keyMap.containsKey(key)) {
			Node ans = keyMap.get(key);
			// increase freq of node.
			DoubleLinkedList list = freqList.get(ans.freq);
			if (ans.freq == minFreq && list.size == 1) {
				// check if need to increase min freq overall.
				minFreq++;
			}

			// remove from freqList
			list.removeFromList(ans);
			ans.freq++;
			if (!freqList.containsKey(ans.freq)) {
				freqList.put(ans.freq, new DoubleLinkedList());
			}
			freqList.get(ans.freq).addToHead(ans);
			// add to a new list, put in front.
			return ans.value;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if (keyMap.containsKey(key)) {
			// just update.
			Node ans = keyMap.get(key);
			ans.value = value;
			DoubleLinkedList list = freqList.get(ans.freq);
			if (ans.freq == minFreq && list.size == 1) {
				// check if need to increase min freq overall.
				minFreq++;
			}
			list.detachNode(ans);
			ans.freq++;
			if (!freqList.containsKey(ans.freq)) {
				freqList.put(ans.freq, new DoubleLinkedList());
			}
			freqList.get(ans.freq).addToHead(ans);
			return;
		} else if (size < capacity) {
			// just add.
			Node ans = new Node(key, value, 1);
			keyMap.put(key, ans);
			minFreq = 1;

			if(!freqList.containsKey(1)) {
				freqList.put(1, new DoubleLinkedList());
			}
			freqList.get(1).addToHead(ans);
			size++;
		} else if (capacity > 0) {
			// remove one.
			DoubleLinkedList minList = freqList.get(minFreq);
			Node target = minList.removeFromTail();
			keyMap.remove(target.key);

			Node ans = new Node(key, value, 1);
			keyMap.put(key, ans);
			minFreq = 1;

			if(!freqList.containsKey(1)) {
				freqList.put(1, new DoubleLinkedList());
			}
			freqList.get(1).addToHead(ans);
		}

	}

	public static void main(String[] args) {
		LFUCache lfu = new LFUCache(10);
		lfu.put(10, 13);
		lfu.put(3, 17);
		lfu.put(6,11);
		lfu.put(10,5);
		lfu.put(10, 13);


//		lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
//		lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//		lfu.get(1);      // return 1
//		// cache=[1,2], cnt(2)=1, cnt(1)=2
//		lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
//		// cache=[3,1], cnt(3)=1, cnt(1)=2
//		lfu.get(2);      // return -1 (not found)
//		lfu.get(3);      // return 3
//		// cache=[3,1], cnt(3)=2, cnt(1)=2
//		lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
//		// cache=[4,3], cnt(4)=1, cnt(3)=2
//		lfu.get(1);      // return -1 (not found)
//		lfu.get(3);      // return 3
//		// cache=[3,4], cnt(4)=1, cnt(3)=3
//		lfu.get(4);      // return 4
//		// cache=[3,4], cnt(4)=2, cnt(3)=3
	}
}