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
    public ListNode oddEvenList(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode e = head;
        ListNode o = head.next;
        ListNode o_head = o;
        while (o != null && o.next!=null){
            e.next = o.next;
            e = o.next;
            o.next =  e.next;
            o = e.next;
        }
        e.next = o_head;
        return head;
    }
}