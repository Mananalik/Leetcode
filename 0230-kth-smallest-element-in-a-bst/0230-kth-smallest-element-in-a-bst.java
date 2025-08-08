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
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        int arr[] = new int[1];
        int result[] = new int[1];
        inorder(root,arr,k,result);
        return result[0];
    }
    static void inorder(TreeNode root , int[] arr,int k, int[] result){
        if(root==null){
            return;
        }
        inorder(root.left,arr,k,result);
        arr[0]++;
        if(k==arr[0]){
            result[0] = root.val;
            return;
        }
        inorder(root.right,arr,k,result);
        return;
    }
}