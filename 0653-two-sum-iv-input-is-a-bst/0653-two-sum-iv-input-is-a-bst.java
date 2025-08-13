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
 public class BSTiterator{
    private Stack<TreeNode> st = new Stack<>();
    boolean reverse = true;
    public BSTiterator(TreeNode root, boolean isReverse){
        reverse = isReverse;
        pushAll(root);
    }
    public boolean hasNext(){
        return !st.isEmpty();
    }
    public int next (){
        TreeNode temp= st.pop();
        if(reverse==false) pushAll(temp.right);
        else pushAll(temp.left);
        return temp.val;
    }
    private void pushAll(TreeNode root){
        while(root!=null){
            if(reverse==true){
                st.push(root);
                root = root.right;
            }else{
                st.push(root);
                root = root.left;
            }
        }
    }
 }
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        BSTiterator l = new BSTiterator(root,false);
        BSTiterator r = new BSTiterator(root,true);
        int i = l.next();
        int j = r.next();
        while(i<j){
            if(i+j==k) return true;
            else if(i+j<k) i = l.next();
            else j = r.next();
        }
        return false;
    }
}