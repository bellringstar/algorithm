package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC234 {

	//연결리스트의 헤드가 주어질때 펠린드롬이면 true 아니면 false
	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		;

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode node) {
			this.val = val;
			this.next = node;
		}

	}

	class Solution {
		public boolean isPalindrome(ListNode head) {
			Deque<Integer> deque = new LinkedList<>();
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
				fast = fast.next.next;
				slow = slow.next;
			}

			if (fast != null) {
				// 홀수개라 slow가 중앙에 있으니 한칸 추가 이동
				slow = slow.next;
			}
			// 역순
			ListNode rev = null;
			while (slow != null) {
				ListNode next = slow.next;
				slow.next = rev;
				rev = slow;
				slow = next;
			}

			while (rev != null) {
				// 비교
				if (rev.val != head.val) {
					return false;
				}
				rev = rev.next;
				head = head.next;
			}
			return true;

		}
	}
}




