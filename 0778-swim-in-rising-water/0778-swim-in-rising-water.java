class Pair{
    int time;
    int row;
    int col;
    Pair(int time , int row, int col){
        this.time = time;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int vis[][] = new int[n][n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.time-y.time);
        pq.add(new Pair(grid[0][0],0,0));
        vis[0][0] = 1;
        int drow[] = {-1,0,+1,0};
        int dcol[] = {0,+1,0,-1};
        while(!pq.isEmpty()){
            int r = pq.peek().row;
            int c = pq.peek().col;
            int tm = pq.peek().time;
            pq.remove();
            for(int i=0;i<4;i++){
                int nrow = r+drow[i];
                int ncol = c+dcol[i];
                if(nrow<n && nrow>=0 && ncol<n && ncol>=0 && vis[nrow][ncol]==0){
                   
                   int newTime = Math.max(tm,grid[nrow][ncol]);
                    if(nrow==n-1 && ncol==n-1){
                        return newTime;
                    }
                    pq.add(new Pair(newTime,nrow,ncol));
                     vis[nrow][ncol]=1;
                }
            }
        } 
        return 0;
    }
}