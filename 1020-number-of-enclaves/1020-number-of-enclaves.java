class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] vis = new int [m][n];
        int drow[] = {-1,0,+1,0};
        int dcol[] = {0,+1,0,-1};
        int count = 0;
        // check for first and last row 
        for(int j = 0;j<n;j++){
            if(vis[0][j]==0 && grid[0][j]==1){
                dfs(0,j,vis,grid,drow,dcol);
            }
            if(vis[m-1][j]==0 && grid[m-1][j]==1){
                dfs(m-1,j,vis,grid,drow,dcol);
            }
        }
        // check for first and last column
        for(int i=0;i<m;i++){
            if(vis[i][0]==0 && grid[i][0]==1){
                dfs(i,0,vis,grid,drow,dcol);
            }
            if(vis[i][n-1]==0 && grid[i][n-1]==1){
                dfs(i,n-1,vis,grid,drow,dcol);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
    static void dfs(int row , int col , int [][] vis , int [][] grid , int []drow , int [] dcol){
        vis[row][col] = 1;
        int m = grid.length;
        int n= grid[0].length;
        for(int i=0;i<4;i++){
            int nrow = row+drow[i];
            int ncol = col+dcol[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow , ncol , vis , grid , drow, dcol);
            }
        }
    }
}