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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = new ListNode ();
        ListNode temp = n1;
        int carry = 0;
        while(l1!=null || l2!=null || carry==1){
            int sum = 0;
            if(l1!=null){
              sum+=l1.val;
             l1 = l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2 = l2.next;
            }
            sum+=carry;
            carry = sum/10;
           ListNode n2 = new ListNode(sum%10);
           temp.next = n2;
           temp = temp.next;
        }
        return n1.next;
    }
}