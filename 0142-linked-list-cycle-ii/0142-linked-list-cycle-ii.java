/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        int length = 0;
        ListNode f = head;
        ListNode s = head;
        while(f!=null && f.next!=null){
            f = f.next.next;
            s = s.next.next;
            if(f==s){
                length = lengthCycle(head);
                break;
            }
        }
        if(length==0){
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        while(length>0){
           second = second.next;
           length--;
        }
        while(first!=second){
            first = first.next;
            second = second.next;
        }
        
        return second;
    }
    static int lengthCycle(ListNode head){
        ListNode f = head;
        ListNode s = head;
        while(f!=null && f.next!=null){
            f= f.next.next;
            s = s.next;
            int length = 0;
            if(f==s){
                ListNode temp = s;
                do{
                    temp = temp.next;
                    length++;
                }while(temp!=s);
                return length;
            }
        }
        return 0;
    }
}