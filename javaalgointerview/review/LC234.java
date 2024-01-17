package review;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class LC234 {
	class Solution {
		public boolean isPalindrome(ListNode head) {
			Deque<Integer> deque = new ArrayDeque<>();
			ListNode node = head;
			while (node != null) {
				deque.add(node.val);
				node = node.next;
			}

			while (!deque.isEmpty() && deque.size() > 1) {
				if (deque.pollFirst() != deque.pollLast()) {
					return false;
				}
			}
			return true;
		}
	}

	class Solution2 {
		public boolean isPalindrome(ListNode head) {
			ListNode fast = head, slow = head;
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			if (fast != null) {
				slow = slow.next;
			}

			ListNode rev = null;
			while (slow != null) {
				ListNode next = slow.next;
				slow.next = rev;
				rev = slow;
				slow = next;
			}

			while (rev != null) {
				if (rev.val != head.val) return false;
				rev = rev.next;
				head = head.next;
			}
			return true;
		}
	}
	class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) {
			this.val = val;}
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
