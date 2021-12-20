package DesignCircularQueue;
import java.util.*;

class MyCircularQueue {
	int[] cache;
	int head;
	int tail;
	int size;
	int capacity;
	public MyCircularQueue(int k) {
		capacity = k;
		cache = new int[k];
	}

	public boolean enQueue(int value) {
		if (isEmpty()) {
			head = 0;
			tail = 0;
			cache[0] = value;
			size++;
			return true;
		}

		if (isFull()) {
			return false;
		}

		tail = (tail + 1) % capacity;
		cache[tail] = value;
		size++;
		return true;
	}

	public boolean deQueue() {
		if (isEmpty()) {
			return false;
		}

		head = (head + 1) % capacity;
		size--;
		return true;
	}

	public int Front() {
		if (isEmpty()) {
			return -1;
		}
		return cache[head];
	}

	public int Rear() {
		if (isEmpty()) {
			return -1;
		}
		return cache[tail];
	}

	public boolean isEmpty() {
		boolean empty = size == 0;
		if (empty) {
			head = -1;
			tail = -1;
		}

		return empty;
	}

	public boolean isFull() {
		boolean full = size == cache.length;
		return full;
	}

	public static void main(String[] args) {
		MyCircularQueue myCircularQueue = new MyCircularQueue(3);
		myCircularQueue.enQueue(1); // return True
		myCircularQueue.enQueue(2); // return True
		myCircularQueue.enQueue(3); // return True
		myCircularQueue.enQueue(4); // return False
		myCircularQueue.Rear();     // return 3
		myCircularQueue.isFull();   // return True
		myCircularQueue.deQueue();  // return True
		myCircularQueue.enQueue(4); // return True
		myCircularQueue.Rear();     // return 4
	}
}

//class MyCircularQueue {
//	int headIndex;
//	int capacity;
//	int count;
//	int[] cache;
//	public MyCircularQueue(int k) {
//		this.capacity = k;
//		this.headIndex = 0;
//		this.count = 0;
//		this.cache = new int[k];
//	}
//
//	public boolean enQueue(int value) {
//		if (isFull()) {
//			return false;
//		}
//
//		cache[ (this.headIndex + this.count) % this.capacity ] = value;
//		this.count++;
//		return true;
//	}
//
//	public boolean deQueue() {
//		if (isEmpty()) {
//			return false;
//		}
//
//		this.headIndex++;
//		this.headIndex = this.headIndex % this.capacity;
//		this.count--;
//
//		return true;
//	}
//
//	public int Front() {
//		if (isEmpty()) {
//			return -1;
//		}
//
//		return cache[headIndex];
//	}
//
//	public int Rear() {
//		if (isEmpty()) {
//			return -1;
//		}
//		return cache[ (headIndex + count - 1) % capacity];
//	}
//
//	public boolean isEmpty() {
//		if (this.count == 0) {
//			return true;
//		}
//
//		return false;
//	}
//
//	public boolean isFull() {
//		if (this.count == this.capacity) {
//			return true;
//		}
//
//		return false;
//	}
//
//	public static void main(String[] args) {
//		MyCircularQueue test = new MyCircularQueue(3);
//		test.enQueue(2);
//		test.Rear();
//		test.Front();
//		test.deQueue();
//		test.Front();
//		test.deQueue();
//		test.Front();
//		test.enQueue(4);
//		test.enQueue(2);
//		test.enQueue(2);
//		test.enQueue(3);
//	}
//}
