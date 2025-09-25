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
class tuple {
    TreeNode node;
    int vertical;
    int level;
    tuple(TreeNode node, int vertical, int level){
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;                   
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(root, 0, 0));

        while (!q.isEmpty()) {
            tuple t = q.poll();
            TreeNode node = t.node;
            int ver = t.vertical;
            int lvl = t.level;

            mp.computeIfAbsent(ver, k -> new TreeMap<>())
              .computeIfAbsent(lvl, k -> new PriorityQueue<>())
              .add(node.val);

            if (node.left != null)  q.add(new tuple(node.left, ver - 1, lvl + 1));
            if (node.right != null) q.add(new tuple(node.right, ver + 1, lvl + 1));
        }

        for (Map<Integer, PriorityQueue<Integer>> levels : mp.values()) {
            List<Integer> col = new ArrayList<>();
            for (PriorityQueue<Integer> pq : levels.values()) {
                while (!pq.isEmpty()) col.add(pq.poll()); 
            }
            ans.add(col);
        }
        return ans;
    }
}
