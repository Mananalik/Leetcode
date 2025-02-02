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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();
        if(root == null){
            return arr;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean lefttoright = true;
        while(!q.isEmpty()){
           
            int n = q.size();
            List<Integer> arr1 = new ArrayList<>();
            for(int i=0;i<n;i++){
                 TreeNode node = q.poll();
             if(lefttoright){
                arr1.add(node.val);
             }else{
                arr1.add(0,node.val);
             }
             if(node.left!=null){
                q.add(node.left);
             }
             if(node.right!=null){
                q.add(node.right);
             }
            }
            lefttoright = !lefttoright;
            arr.add(arr1);
        }
         return arr;
    }
   
}