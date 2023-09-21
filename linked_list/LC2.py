class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


# 연결리스트는 비어있지 않고 음수가 아니다.
# [2,4,3] = 342, [5,6,4] = 465 => 342+465 = 807 => output:[7,0,8]
# [9,9,9,9,9,9,9] = 9999999 , [9,9,9,9] = 9999 => 10,009,998 => [8,9,9,9,0,0,1]
# 차례로 더해가며 올림수가 발생시 그걸 다음 단계에 전달해 더해준다.
# 둘 중 값이 없다 = null이다 : 0 or 올림수 존재시 그것을 더해준다.


class Solution:
    # 1. 그냥 숫자로 만든 다음에 더하고 다시 연결리스트로 만든다
    def addTwoNumbers(self, l1: [ListNode], l2: [ListNode]) -> [ListNode]:
        def make_num(l1: [ListNode]) -> int:
            string = ""
            curr = l1
            while curr:
                string += str(curr.val)
                curr = curr.next
            return int(string[::-1])

        num1 = make_num(l1)
        num2 = make_num(l2)
        rst = str(num1 + num2)
        rst = rst[::-1]
        head = ListNode()
        curr = head
        for i in range(len(rst)):
            curr.next = ListNode(rst[i])
            curr = curr.next
        return head.next

    def addTwoNumbers(self, l1: [ListNode], l2: [ListNode]) -> [ListNode]:
        root = head = ListNode[0]

        carry = 0
        while l1 or l2 or carry:
            sum = 0
            if l1:
                sum += l1.val
                l1 = l1.next
            if l2:
                sum += l2.val
                l2 = l2.val

            carry, val = divmod(sum + carry, 10)
            head.next = ListNode(val)
            head = head.next
        return root.next
