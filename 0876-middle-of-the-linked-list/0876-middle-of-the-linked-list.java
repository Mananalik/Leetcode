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
    public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while(f!=null && f.next!=null){
            s = s.next;
            f = f.next.next;
        }
        return s;
        // ListNode temp = head;
        // int length = 0;
        // while(temp!=null){
        //     temp = temp.next;
        //     length++;
        // }
        // ListNode temp2= head;
        // int l=0;
        // while(l!=length/2){
        //     temp2 =temp2.next;
        //     l++;
        // }
        // return temp2;
    }
}