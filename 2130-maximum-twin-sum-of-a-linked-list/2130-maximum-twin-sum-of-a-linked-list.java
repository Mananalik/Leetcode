/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
       ListNode mid = getMid(head);
       ListNode secondHalf = mid.next;
       mid.next = null;
       secondHalf = reverse(secondHalf);
       int maxi = Integer.MIN_VALUE;
       while(secondHalf!=null){
        int sum = head.val + secondHalf.val;
        maxi = Math.max(maxi,sum);
        head = head.next;
        secondHalf = secondHalf.next;
       }
       return maxi;
    }
    public ListNode getMid(ListNode node){
        ListNode fast = node;
        ListNode slow = node;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
   public ListNode reverse(ListNode node) {
    ListNode prev = null;
    ListNode curr = node;

    while (curr != null) {
        ListNode next = curr.next; 
        curr.next = prev;          
        prev = curr;               
        curr = next;               
    }

    return prev;
}
}