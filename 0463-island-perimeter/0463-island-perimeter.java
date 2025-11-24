class Pair{
    int r;
    int c;
    Pair(int r, int c){
        this.r = r;
        this.c = c;
    }
}
class Solution {
    public int islandPerimeter(int[][] grid) {
        // int rows = grid.length;
        // int cols = grid[0].length;
        // int vis[][] = new int [rows][cols];
        // int nrow[] = {0,-1,0,+1};
        // int ncol[] = {-1,0,+1,0};
        // for(int i=0;i<rows;i++){
        //     for(int j=0;j<cols;j++){
        //         if(grid[i][j]==1){
        //             Queue<Pair> q=  new LinkedList<>();
        //             vis[i][j] = 1;
        //             q.add(new Pair(i,j));
        //             int perimeter = 0;
        //             while(!q.isEmpty()){
        //                 Pair p = q.poll();
        //                 int row = p.r;
        //                 int col = p.c;
        //                 for(int x=0;x<4;x++){
        //                         int nr = row+nrow[x];
        //                         int nc = col+ncol[x];
        //                         if (nr<0 || nc<0 || nr>=rows || nc>=cols ||
        //                                 grid[nr][nc]==0){
        //                                     perimeter++;
        //                                 }else{
        //                                     if(vis[nr][nc]==0){
        //                                         vis[nr][nc]=1;
        //                                         q.add(new Pair(nr,nc));
        //                                     }
        //                                 }

                            
        //                 }
        //             }
        //             return perimeter;
        //         }
        //     }
        // }
        // return 0;


        // dfs
        int rows = grid.length;
        int cols = grid[0].length;
        int vis[][] = new int [rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    return dfs(i,j,grid,vis);
                }
            }
        }
        return 0;
    }
    public int dfs(int row, int col , int [][] grid , int [][] vis){
        int rows = grid.length;
        int cols = grid[0].length;
        if(row<0 || col<0 || row>=rows || col>=cols){
            return 1;
        }
        if(grid[row][col]==0) return 1;
        if(vis[row][col]==1) return 0;
        vis[row][col] =1;
        int perimeter = 0;
        perimeter+=dfs(row,col-1,grid,vis);
        perimeter+=dfs(row-1,col,grid,vis);
        perimeter+=dfs(row,col+1,grid,vis);
        perimeter+=dfs(row+1,col,grid,vis);
        return perimeter;
    }
}