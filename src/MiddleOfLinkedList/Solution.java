package MiddleOfLinkedList;
import javax.sound.midi.Soundbank;
import java.util.*;



 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public static ListNode middleNode(ListNode head) {
        ListNode median = head;
        ListNode doubleMedian = head;

        while (doubleMedian != null && doubleMedian.next != null) {
            median = median.next;
            doubleMedian = doubleMedian.next.next;
        }

        return median;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;


        Solution.middleNode(one);
    }
}