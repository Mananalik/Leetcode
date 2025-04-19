# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None or head.next is None:
            return head
        e = head
        o = head.next
        o_head = o
        while o and o.next:
            e.next = o.next
            e = o.next
            o.next = e.next
            o = e.next
        e.next = o_head
        return head