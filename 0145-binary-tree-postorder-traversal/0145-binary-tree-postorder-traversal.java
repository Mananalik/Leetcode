/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
        this.next = null;
    }
}
class MyListNode{
    private Node head;
    public MyListNode(){
        head = null;
    }
    public void addNew(int val){
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }
    public List<Integer> toList(){
        List<Integer> result = new ArrayList<>();
        Node curr = head;
        while(curr!=null){
            result.add(curr.val);
            curr = curr.next;
        }
        return result;
    }
}
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        MyListNode ans = new MyListNode();
        Stack<TreeNode> st = new Stack<>();
        if(root==null) return ans.toList();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            ans.addNew(curr.val);
            if(curr.left!=null){
                st.add(curr.left);
            }
            if(curr.right!=null){
                st.add(curr.right);
            }
        }
        return ans.toList();
    }
    
}