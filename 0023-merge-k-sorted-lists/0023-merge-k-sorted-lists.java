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
    public ListNode mergeKLists(ListNode[] lists) {
      if(lists.length==0){
        return null;
      }
      return mergeK(lists,0,lists.length-1);   
    }
    static ListNode mergeK(ListNode [] lists , int start , int end){
        if(start==end){
            return lists[start];
        }
        if(start+1==end){
            return merge(lists[start],lists[end]);
        }
        int mid = start+(end-start)/2;
        ListNode left = mergeK(lists,start,mid);
        ListNode right = mergeK(lists,mid+1,end);
        return merge(left,right);
    }
    static ListNode merge(ListNode list1 , ListNode list2){
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        while(list1!=null){
            temp.next = list1;
            list1 = list1.next;
            temp = temp.next;
        }
        while(list2!=null){
            temp.next = list2;
            list2 = list2.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}