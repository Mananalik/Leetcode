class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
      int rows = grid.length;
      int cols = grid[0].length;
      int[][] vis = new int [rows][cols];
      int drow[] = {-1,0,+1,0};
      int dcol[] = {0,+1,0,-1};
      int maxi = 0;
      for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){
             if(vis[i][j]==0 && grid[i][j]==1){
                Queue<Pair> q = new LinkedList<>();
                int count = 0;
                q.add(new Pair(i,j));
                vis[i][j] = 1;
                while(!q.isEmpty()){
                    Pair p = q.poll();
                    count++;
                    int row = p.row;
                    int col = p.col;

                    for(int x=0;x<4;x++){
                        int nrow = row + drow[x];
                        int ncol = col + dcol[x];
                        if(nrow>=0 && nrow<rows && ncol>=0 && ncol<cols && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                            q.add(new Pair(nrow,ncol));
                            vis[nrow][ncol] = 1;
                        }
                    }
                }
                maxi = Math.max(maxi,count);
             }
             
        }
      }
      return maxi;
    }
}