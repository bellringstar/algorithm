package leetcode;

public class LC21 {

	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	// lst1과 lst2를 합쳐라. 하나의 정렬된 리스트로.

	class Solution {
		public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
			ListNode root = new ListNode();
			ListNode head = root;

			while (list1 != null && list2 != null) {
				if (list1.val <= list2.val) {
					head.next = list1;
					list1 = list1.next;
				} else {
					head.next = list2;
					list2 = list2.next;
				}
				head = head.next;
			}

			if (list1 != null) {
				head.next = list1;
			}
			if (list2 != null) {
				head.next = list2;
			}

			return root.next;

		}

	}
}
