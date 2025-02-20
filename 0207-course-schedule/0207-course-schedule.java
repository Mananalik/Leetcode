class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        int vis[] = new int [V];
        int pathVis[] = new int [V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int []x:prerequisites){
            adj.get(x[1]).add(x[0]);
        }
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,adj,vis, pathVis)){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean dfs(int node , ArrayList<ArrayList<Integer>> adj,int[] vis , int[] pathVis){
        vis[node] = 1;
        pathVis[node] = 1;
        for(int it: adj.get(node)){
            if(vis[it]==0){
                if(dfs(it,adj,vis,pathVis)){
                    return true;
                }
            }else if(pathVis[it]==1){
                return true;
            }
        }
        pathVis[node] = 0;
        return false;
    }
}