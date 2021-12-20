package DesignLinkedList;
import java.util.*;

class Node {
	Integer val;
	Node next;

	Node (Integer val) {
		this.val = val;
	}
}

class MyLinkedList {
	Node head;
	Node tail;
	int size;

	public MyLinkedList() {
		head = new Node(null);
		tail = new Node(null);
		head.next = tail;
		size = 0;
	}

	public int get(int index) {
		if (index >= size) {
			return -1;
		}
		Node iter = head;
		while (index > 0) {
			iter = iter.next;
			index--;
		}

		return iter.next.val;
	}

	public void addAtHead(int val) {
		if (head.next == tail) {
			Node curr = new Node(val);
			head.next = curr;
			curr.next = tail;
			size++;
			return;
		}

		Node curr = new Node(val);
		curr.next = head.next;
		head.next = curr;
		size++;
	}

	public void addAtTail(int val) {
		if (head.next == tail) {
			Node curr = new Node(val);
			head.next = curr;
			curr.next = tail;
			size++;
			return;
		}
		Node curr = new Node(val);
		Node prev = head;
		while (prev.next != tail) {
			prev = prev.next;
		}

		prev.next = curr;
		curr.next = tail;
		size++;
	}

	public void addAtIndex(int index, int val) {
		if (index > size) {
			return;
		}
		Node iter = head;
		while (index > 0) {
			iter = iter.next;
			index--;
		}

		Node curr = new Node(val);
		curr.next = iter.next;
		iter.next = curr;
		size++;
	}

	public void deleteAtIndex(int index) {
		if (index >= size) {
			return;
		}

		Node iter = head;

		while (index > 0) {
			iter = iter.next;
			index--;
		}

		iter.next = iter.next.next;
		size--;
	}

	public static void main(String[] args) {
		MyLinkedList test = new MyLinkedList();
		test.addAtHead(1);
		test.addAtTail(3);
		test.addAtIndex(1,2);
		test.get(1);
		test.deleteAtIndex(1);
		test.get(1);
	}
}
