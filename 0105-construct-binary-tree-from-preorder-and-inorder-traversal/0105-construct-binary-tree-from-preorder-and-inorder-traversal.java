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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       Map <Integer,Integer> map = new HashMap<>();
       for(int i = 0;i<inorder.length;i++){
        map.put(inorder[i],i);
       }
       TreeNode root = treeMap(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
       return root;
    }
    static TreeNode treeMap(int[]preorder, int prestart, int preEnd , int[] inorder , int instart,int inEnd,Map<Integer,Integer> map){
        if(prestart>preEnd || instart>inEnd){
            return null;
        }
        TreeNode node = new TreeNode(preorder[prestart]);
        int pos = map.get(node.val);
        int numLeft = pos-instart;
        node.left = treeMap(preorder , prestart+1, prestart+numLeft, inorder , instart, pos-1,map);
        node.right = treeMap(preorder , prestart+numLeft+1,preEnd, inorder , pos+1, inEnd,map);
        return node;
    }
}