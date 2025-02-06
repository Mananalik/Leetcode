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
 class Pair{
    int num;
    TreeNode root;
    Pair( TreeNode root,int num){
        this.num = num;
        this.root = root;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
    Queue<Pair> q = new LinkedList<Pair>();
    int max = 0;
    q.add(new Pair(root,0));
    while(!q.isEmpty()){
        int first = 0;
        int last = 0;
        int size = q.size();
        int min = q.peek().num;
        for(int i = 0;i<size;i++){
           int curr = q.peek().num-min;
           TreeNode node1 = q.peek().root;
           q.poll();
           if(i==0){
            first = curr;
           }
           if(i==(size-1)){
            last = curr;
           }
           if(node1.left!=null){
            q.add(new Pair(node1.left,2*curr+1));
           }
           if(node1.right!=null){
            q.add(new Pair(node1.right,2*curr+2));
           }
        }
        max = Math.max(max,last-first+1);
    }
    return max;
    }
}