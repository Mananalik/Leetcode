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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode f = head;
        ListNode s = head;
        for(int i=0;i<n;i++){
             f = f.next;
        }
        if(f==null){
            return head.next;
        }
        while(f.next!=null){
            f = f.next;
            s = s.next;
        }
        // ListNode temp = s.next;
        s.next = s.next.next;
        return head;
    }
}