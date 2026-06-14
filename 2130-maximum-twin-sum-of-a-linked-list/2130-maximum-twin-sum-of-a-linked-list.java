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
        HashMap<Integer,Integer> mp = new HashMap<>();
        ListNode temp = head;
        int i = 0;
        while(temp!=null){
            mp.put(i,temp.val);
            temp = temp.next;
            i++;
        }
        int len = i;
        int maxi = Integer.MIN_VALUE;
        for(int j = 0;j<len/2;j++){
            int sum = mp.get(j) + mp.get(len-j-1);
            maxi = Math.max(maxi,sum);
        }
        return maxi;
    }
}