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
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        // Queue<TreeNode> q = new LinkedList<>();
        // int level = 0;
        // q.add(root);
        // while (!q.isEmpty()) {
        //     int size = q.size();
        //     for (int i = 0; i < size; i++) {
        //         TreeNode front = q.poll();
        //         if (front.left != null) {
        //             q.add(front.left);
        //         }
        //         if (front.right != null) {
        //             q.add(front.right);
        //         }
        //     }
        //     level++;
        // }
        // return level;
        return level(root,0);
    }
    static int level(TreeNode root, int depth){
        if(root==null){
            return depth;
        }
        return Math.max(level(root.left,depth+1),level(root.right,depth+1));
    }
}