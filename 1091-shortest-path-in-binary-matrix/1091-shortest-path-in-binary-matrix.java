class tupple{
    int distance;
    int row;
    int col;
    tupple(int distance , int row , int col){
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0) {
            return -1;
        }
        int [][]dist = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dist[i][j] = (int)1e9;
            }
        }
        Queue<tupple> q = new LinkedList<>();
        dist[0][0] = 1;
        q.add(new tupple(dist[0][0],0,0));
        int[] drow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dcol = {-1, 0, 1, -1, 1, -1, 0, 1}; 
        while(!q.isEmpty()){
            int distance = q.peek().distance;
            int r = q.peek().row;
            int c = q.peek().col;
            q.remove();
            if(r== m-1 && c==n-1){
                            return distance;
                        }
            for(int i=0;i<8;i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]==0 && distance+1<dist[nrow][ncol]){
                        dist[nrow][ncol] = distance+1;
                        // if(nrow== m-1 && ncol==n-1){
                        //     return distance+1;
                        // }
                        q.add(new tupple(distance+1 ,nrow,ncol ));
                }
            }
        }
        return -1;
    }
}