package linked_list;

public class LC328 {

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

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) {
                return head;
            }

            ListNode odd_start = head;
            ListNode even_start = head.next;

            while (head != null && head.next != null) {
                ListNode tmp = head.next;
                head.next = head.next.next;
                head = tmp;
            }

            ListNode start = odd_start;
            while (odd_start.next != null) {
                odd_start = odd_start.next;
            }

            odd_start.next = even_start;

            return start;

        }
    }

}
