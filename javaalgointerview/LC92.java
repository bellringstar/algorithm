public class LC92 {
	class Solution {
		/*
		left의 이전 지점, right의 다음 지점 기록
		left부터 right까지 뒤집기
		left이전 노드와 right의 다음 노드를 합치기
		 */
		public ListNode reverseBetween(ListNode head, int left, int right) {
			if (head == null) return null;

			ListNode root = new ListNode();
			root.next = head;
			ListNode start = root;
			for (int i = 0; i < left - 1; i++) {
				start = start.next;
			}
			ListNode end = start.next;

			for (int i = 0; i < right - left; i++) {
				ListNode tmp = start.next;
				start.next = end.next;
				end.next = end.next.next;
				start.next.next = tmp;
			}
			return root.next;
		}
	}
	class ListNode {
		int val;
		ListNode next;

		public ListNode() {

		}

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
