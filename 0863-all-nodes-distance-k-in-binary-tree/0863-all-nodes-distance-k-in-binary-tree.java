/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parents = new HashMap<>();
        parentFind(root,parents);
        Map<TreeNode, Boolean> appeared = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(target);
        appeared.put(target,true);
        int x = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(x==k){
                break;
            }
            x++;
            for(int i=0;i<size;i++){
            TreeNode node = q.poll();
            if(node.left!=null && appeared.get(node.left)==null){
                q.offer(node.left);
                appeared.put(node.left,true);
            }
            if(node.right!=null && appeared.get(node.right)==null){
                q.offer(node.right);
                appeared.put(node.right,true);
            }
            if(parents.get(node)!=null && appeared.get(parents.get(node))==null){
                q.offer(parents.get(node));
                appeared.put(parents.get(node),true);
            }
            }
        }
        List<Integer> arr = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            arr.add(node.val);
        }
        return arr;
    }
    static void parentFind(TreeNode root, Map<TreeNode,TreeNode> parents){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left!=null){
                parents.put(node.left,node);
                q.offer(node.left);
            }
             if(node.right!=null){
                parents.put(node.right,node);
                q.offer(node.right);
            }
        }
    }
}