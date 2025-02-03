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
 class Tuple{
    TreeNode node;
    int row ;
    int col;
    public Tuple(TreeNode _node , int _row , int _col){
    node = _node;
    row = _row;
    col = _col;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
 TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> nodes = new TreeMap<>();

        Queue<Tuple> todo = new LinkedList<Tuple>();
        todo.add(new Tuple(root,0,0));
        while (!todo.isEmpty()) {
            Tuple tuple = todo.poll();
            TreeNode temp = tuple.node;
            int x = tuple.row;
            int y = tuple.col;
            if(!nodes.containsKey(x)){
                nodes.put(x,new TreeMap<>());
            }
            if(!nodes.get(x).containsKey(y)){
                nodes.get(x).put(y,new PriorityQueue<>());
            }
            nodes.get(x).get(y).offer(temp.val);
            if (temp.left != null) {
                todo.offer(new Tuple(temp.left,x-1,y+1));
            }
             if (temp.right != null) {
                todo.offer(new Tuple(temp.right,x+1,y+1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer,PriorityQueue<Integer>> entry : nodes.values()) {
           ans.add(new ArrayList<>());
            for (PriorityQueue<Integer> node: entry.values()) {
                while(!node.isEmpty()){
                 ans.get(ans.size()-1).add(node.poll());
                }
            }
        
        }
        return ans;
    }
}