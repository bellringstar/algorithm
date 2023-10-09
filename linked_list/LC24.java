package linked_list;

public class LC24 {

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
        public ListNode swapPairs(ListNode head) {

            ListNode prev = new ListNode();
            ListNode root = prev;
            prev.next = head;
            while (head != null && head.next != null) {
                ListNode tmp = head.next;
                head.next = tmp.next;
                tmp.next = head;
                prev.next = tmp;

                head = head.next;
                prev = prev.next.next;
            }

            return root.next;
        }
    }

}