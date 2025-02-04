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
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return false;
        }
     return   isSymmetric1(root.left,root.right);
    }
    static boolean isSymmetric1(TreeNode node1 , TreeNode node2){
        if(node1==null || node2==null){
            return node1==node2;
        }
      return (node1.val == node2.val) 
              && isSymmetric1(node1.left,node2.right) 
              && isSymmetric1(node1.right, node2.left);
    }
}