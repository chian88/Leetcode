package MergedKSortedList;
import java.util.*;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }



class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> {
			return Integer.compare(a.val, b.val);
		});

		for (ListNode list : lists) {
			if (list != null) {
				heap.add(list);
			}

		}
		ListNode res = new ListNode();
		ListNode iter = res;
		while (!heap.isEmpty()) {
			ListNode currMin = heap.poll();

			iter.next = new ListNode(currMin.val);
			iter = iter.next;
			currMin = currMin.next;

			if (currMin != null) {
				heap.add(currMin);
			}


		}

		return res.next;


	}
//	public ListNode mergeKLists(ListNode[] lists) {
//		ListNode res = new ListNode();
//
//		ListNode resIter = res;
//
//
//
//		while (true) {
//			int currMin = Integer.MAX_VALUE;
//			int currMinIdx = 0;
//			for (int i = 0; i < lists.length; i++) {
//				if (lists[i] == null) {
//					continue;
//				}
//				if (lists[i].val < currMin) {
//					currMin = lists[i].val;
//					currMinIdx = i;
//				}
//			}
//
//			if (currMin == Integer.MAX_VALUE) {
//				break;
//			}
//
//			resIter.next = new ListNode(currMin);
//			resIter = resIter.next;
//			lists[currMinIdx] = lists[currMinIdx].next;
//		}
//		return res.next;
//	}

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		one.next = four;
		four.next = five;

		ListNode one2 = new ListNode(1);
		ListNode three2 = new ListNode(3);
		ListNode four2 = new ListNode(4);
		one2.next = three2;
		three2.next = four2;

		ListNode two3 = new ListNode(2);
		ListNode six3 = new ListNode(6);
		two3.next = six3;

		Solution teest = new Solution();
		teest.mergeKLists(new ListNode[]{one, one2, two3});
	}
}