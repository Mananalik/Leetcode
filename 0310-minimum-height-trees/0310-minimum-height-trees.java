class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        if(n==1){
            ans.add(0);
            return ans;
        }
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int degree[] = new int[n];
        for(int arr[]: edges){
            int u = arr[0];
            int v = arr[1];
            degree[u]++;
            degree[v]++;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int remNodes = n;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1) q.add(i);
        }
        while(remNodes>2 && !q.isEmpty()){
            int size= q.size();
            for(int i=0;i<size;i++){
                int node = q.poll();
                remNodes--;
                for(int nodes: adj.get(node)){
                    degree[nodes]--;
                    if(degree[nodes]==1){
                        q.add(nodes);
                    }
                }
                
            }
            
        }
        int size = q.size();
        for(int i=0;i<size;i++){
            ans.add(q.poll());
        }
        return ans;
    }
}