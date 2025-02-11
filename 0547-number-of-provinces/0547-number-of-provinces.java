class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean vis[]  = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(isConnected , vis , i);
            }
        }
        return count;
    }
    static void dfs(int[][] mat ,boolean vis[] , int i ){
        for(int j =0 ;j<mat[i].length;j++){
            if(!vis[j] && mat[i][j]!=0){
                vis[j] = true;
                dfs(mat , vis , j);
            }
        }
    }
}