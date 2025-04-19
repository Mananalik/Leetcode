# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if head==None or k==0 or head.next==None:
            return head
        count=1
        tail = head
        while tail.next:
            tail = tail.next
            count+=1
        k = k%count
        if k==0:
            return head
        moves = count-k
        temp = head
        for i in range (0,moves-1,1):
            temp = temp.next
        new_head = temp.next
        temp.next=None
        tail.next=head
        return new_head