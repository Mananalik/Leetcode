# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
   def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists:
            return None
        return self.mergeK(lists, 0, len(lists) - 1)
   def mergeK(self, lists: List[Optional[ListNode]], start: int, end: int) -> Optional[ListNode]:
        if start == end:
            return lists[start]
        if start + 1 == end:
            return self.merge(lists[start], lists[end])
        mid = start + (end - start) // 2
        left = self.mergeK(lists, start, mid)
        right = self.mergeK(lists, mid + 1, end)
        return self.merge(left, right)
   def merge(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if not list1:
            return list2
        if not list2:
            return list1
        dummy = ListNode()
        temp = dummy
        while list1 and list2:
            if list1.val <= list2.val:
                temp.next = list1
                list1 = list1.next
            else:
                temp.next = list2
                list2 = list2.next
            temp = temp.next
        while list1:
            temp.next = list1
            list1 = list1.next
            temp = temp.next
        while list2:
            temp.next = list2
            list2 = list2.next
            temp = temp.next
        return dummy.next