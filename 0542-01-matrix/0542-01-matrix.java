class Pair{
    int row;
    int col;
    int path;
    Pair(int row , int col , int path){
        this.row = row;
        this.col = col;
        this.path = path;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int [][] vis = new int[m][n];
        int [][] dist = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
              if(mat[i][j]==0){
                vis[i][j] = 1;
                q.add(new Pair(i,j,0));

              }else{
                dist[i][j] = Integer.MAX_VALUE;
              }
           }
        }
        int drow[] = {-1,0,+1,0};
        int dcol[] = {0,+1,0,-1};
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int p = q.peek().path;
            q.remove();
            dist[r][c] = p;
            for(int i=0;i<4;i++){
                 int nrow = r+drow[i];
                 int ncol = c+dcol[i];
                 if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0){
                  vis[nrow][ncol] = 1;
                  q.add(new Pair(nrow, ncol ,p+1));
                 }
                }
        }
       return dist;
    }
}