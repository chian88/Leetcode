package KthSmallestElementInSortedMatrix;
import java.util.*;

class HeapNode {
	int row;
	int col;
	int val;

	HeapNode(int row, int col, int val) {
		this.row = row;
		this.col = col;
		this.val = val;
	}
}

class Solution {
	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<HeapNode> heap = new PriorityQueue<>( (a, b) -> {
			return a.val - b.val;
		});

		for (int r = 0; r < matrix.length; r++) {
			heap.add(new HeapNode(r, 0, matrix[r][0]));
		}

		int count = 0;
		HeapNode curr = null;
		while (count < k) {
			curr = heap.poll();
			if (curr.col + 1 < matrix.length) {
				heap.add(new HeapNode(curr.row, curr.col + 1, matrix[curr.row][curr.col + 1]));
			}
			count++;
		}

		return curr.val;
	}

	public static void main(String[] args) {
		Solution test = new Solution();

		test.kthSmallest(new int[][]{{1,5,9} , {10,11,13}, {12,13,15}}, 8);

	}
}