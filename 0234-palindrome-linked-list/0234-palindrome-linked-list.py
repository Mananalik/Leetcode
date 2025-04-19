# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: bool
        """
        mid = self.get_mid(head)
        rev = self.reverse(mid)
        first= head
        second = rev
        while first is not None and second is not None:
            if(first.val != second.val):
                return False
            first = first.next
            second = second.next
        return True
    
    def get_mid(self,head):
        f = head
        s = head
        while f is not None and f.next is not None:
            f = f.next.next
            s = s.next
        return s
    def reverse(self,head):
        prev = None
        present = head
        next1 = present.next
        while present is not None:
             present.next = prev
             prev = present
             present = next1
             if next1 is not None:
                next1 = next1.next
        return prev

        