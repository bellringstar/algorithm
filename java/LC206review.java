public class LC206review {

    class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }
    // 역순으로 정렬

    class Solution {
        ListNode reverse(ListNode node, ListNode prev) {
            if (node == null) {
                return prev;
            }
            ListNode next = node.next;
            node.next = prev;
            return reverse(next, node);
         }
        public ListNode reverseList(ListNode head) {
            return reverse(head, null);
        }
    }

    class Solution2 {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null, node = head;
            while (node != null) {
                ListNode next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }
            return prev;
        }
    }

}
