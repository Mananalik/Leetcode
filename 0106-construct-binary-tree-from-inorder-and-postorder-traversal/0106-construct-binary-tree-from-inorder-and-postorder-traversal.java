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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return treeMap(postorder , 0 , postorder.length-1 , inorder , 0, inorder.length-1, map);
    }
    static TreeNode treeMap(int [] postorder , int postStart , int postEnd , int [] inorder , int inStart , int inEnd , Map<Integer,Integer> map){
        if(postStart>postEnd || inStart>inEnd){
            return null;
        }
        TreeNode node  = new TreeNode(postorder[postEnd]);
        int pos = map.get(node.val);
        int numLeft = pos-inStart;
        node.left = treeMap(postorder,postStart,postStart+numLeft-1,inorder,inStart,pos-1,map);
        node.right = treeMap(postorder,postStart+numLeft,postEnd-1,inorder,pos+1,inEnd,map);
        return node;
    }
}