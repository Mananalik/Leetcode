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
    public int goodNodes(TreeNode root) {
        return dfs(root,root.val);
    }
    public int dfs(TreeNode root , int maxi){
        if(root==null) return 0;
        int cnt = 0;
        if(root.val>=maxi){
            cnt++;
            maxi = root.val;
        }
        cnt+=dfs(root.left,maxi);
        cnt+=dfs(root.right,maxi);
        return cnt;
    }
}