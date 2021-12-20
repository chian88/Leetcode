package LRUCache;
import java.util.*;

class Node {
	Node prev;
	Node next;
	Integer key;
	Integer value;

	Node (Integer key, Integer value) {
		this.key = key;
		this.value = value;
	}
}

class DoubleLinkedList {
	Node head;
	Node tail;

	DoubleLinkedList() {
		head = new Node(null, null);
		tail = new Node(null, null);
		head.next = tail;
		tail.prev = head;
	}

	void addToHead(Node key) {
		Node temp = head.next;
		head.next = key;
		key.prev = head;
		key.next = temp;
		temp.prev = key;
	}

	void moveToHead(Node key) {
		removeSelf(key);

		Node temp = head.next;
		key.next = temp;
		temp.prev = key;
		key.prev = head;
		head.next = key;
	}

	void removeSelf(Node key) {
		Node prev = key.prev;
		Node next = key.next;
		prev.next = next;
		next.prev = prev;
	}

	Node popTail() {
		Node temp = tail.prev.prev;
		Node target = tail.prev;

		temp.next = tail;
		tail.prev = temp;

		return target;
	}
}

class LRUCache {
	DoubleLinkedList list;
	Map<Integer, Node> map;
	int capacity;

	public LRUCache(int capacity) {
		list = new DoubleLinkedList();
		map = new HashMap<>();
		this.capacity = capacity;
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
 		Node res = map.get(key);

		list.moveToHead(res);

		return res.value;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			Node target = map.get(key);
			target.value = value;
			list.moveToHead(target);
			return;
		}

		if (map.size() == capacity) {
			Node target = list.popTail();
			map.remove(target.key);
		}
		Node target = new Node(key, value);
		list.addToHead(target);
		map.put(key, target);
	}

}

class Solution {
	public static void main(String[] args) {
		LRUCache lRUCache = new LRUCache(2);
		lRUCache.get(2);
		lRUCache.put(2,6);
		lRUCache.get(1);
		lRUCache.put(1, 5);
		lRUCache.put(1,2);
		lRUCache.get(1);
		lRUCache.get(2);
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */