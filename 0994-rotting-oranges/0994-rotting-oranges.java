class Pair{
    int row;
    int col;
    int time;
    Pair(int row , int col , int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int row = grid.length;
        int col = grid[0].length;
        int cntFresh = 0;
        int vis[][] = new int[row][col];
        Queue<Pair> q = new LinkedList<Pair>();
        for(int i=0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 2;
                }else{
                    vis[i][j] = 0;
                }
                if(grid[i][j]==1){
                    cntFresh++;
                }
            }
        }
        int tm = 0;
        int drow[] = {-1,0,+1,0};
        int dcol[] = {0,+1,0,-1};
        int count = 0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            tm = Math.max(tm,t);
            q.remove();
            for(int i=0;i<4;i++){
                int nrow = r+drow[i];
                int ncol = c+dcol[i];
                if(nrow>=0 && nrow<row && ncol>=0 && ncol<col && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    vis[nrow][ncol] = 2;
                    q.add(new Pair(nrow,ncol,t+1));
                    count++;
                }
            }

            
        }
        if(count!=cntFresh){
                return -1;
                    }
        return tm;            
    }
}