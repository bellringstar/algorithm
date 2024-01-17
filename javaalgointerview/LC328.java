public class LC328 {
	class Solution {
		// 연결리스트를 홀수번째 만 먼저 연결리스트로 만드록 뒤에 짝수만 연결리스트로 만들어 합친다. 기존의 내부 순서는 유지돼야한다.
		public ListNode oddEvenList(ListNode head) {
			if (head == null) return head;
			ListNode odd = head;
			ListNode even = head.next;
			ListNode evenHead = even;

			while (even != null && even.next != null) {
				odd.next = odd.next.next;
				even.next = even.next.next;

				odd = odd.next;
				even = even.next;
			}
			odd.next = evenHead;
			return head;
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
