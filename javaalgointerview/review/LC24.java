package review;

public class LC24 {
	class Solution {
		// 노드를 2개씩 스왑 0,1 스왑/ 2,3 스왑...
		public ListNode swapPairs(ListNode head) {

			ListNode prev = new ListNode();
			ListNode root = prev;
			prev.next = head;
			while (prev.next != null && prev.next.next != null) {
				ListNode curr = prev.next;
				ListNode next = prev.next.next;
				curr.next = next.next;
				prev.next = next;
				prev.next.next = curr;
				prev = prev.next.next;
			}
			return root.next;
		}

		public ListNode recursiveSwap(ListNode head) {
			if (head != null && head.next != null) {
				ListNode p = head.next;
				head.next = recursiveSwap(head.next.next);
				p.next =head;
				return p;
			}
			return head;
 		}

		class ListNode {
			int val;
			ListNode next;

			public ListNode(){}

			public ListNode(int val) {
				this.val = val;
			}

			public ListNode(int val, ListNode next) {
				this.val = val;
				this.next = next;
			}
		}
	}
}
