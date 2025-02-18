class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int color[] = new int[V];
        for(int i=0;i<V;i++){
            color[i] = -1;
        }
        for(int i = 0;i<V;i++){
            if(color[i]==-1){
                 if(!dfs(i,0,color,graph)){
                return false;
            }
            }
           
        }
        return true;
    }
    static boolean dfs(int node , int col , int [] color , int[][] adj){
        color[node] = col;
        for(int i : adj[node]){
            if(color[i]==-1){
                if(!dfs(i,1-col,color,adj)){
                    return false;
                }
            }else if(color[i]==col){
                return false;
            }
        }
        return true;
    }
}