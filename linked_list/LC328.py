# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    # 홀수 헤드, 짝수 헤드를 정해
    def oddEvenList(self, head: [ListNode]) -> [ListNode]:
        if not head:
            return head

        odd_start = head
        even_start = head.next
        while head and head.next:
            tmp = head.next
            head.next = head.next.next
            head = tmp
        start = odd_start
        while odd_start.next:
            odd_start = odd_start.next

        odd_start.next = even_start
        return start

    def oddEvenList(self, head: [ListNode]) -> [ListNode]:
        if head is None:
            return None

        odd = head
        even = head.next
        even_head = head.next

        while even and even.next:
            odd.next, even.next = odd.next.next, even.next.next
            odd, next = odd.next, even.next

        odd.next = even_head

        return head
