class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int [][] vis = new int [m][n];
        int drow[] = {-1,0,+1,0};
        int dcol[] = {0,+1,0,-1};
        // checking for first and last row
        for(int j = 0;j<n;j++){
           if(vis[0][j]==0 && board[0][j]=='O'){
            dfs(0,j,vis,board,drow,dcol);
           }
           if(vis[m-1][j]==0 && board[m-1][j]=='O'){
            dfs(m-1,j,vis,board,drow,dcol);
           }
        }
        // checking for first and last column
        for(int i=0;i<m;i++){
           if(vis[i][0]==0 && board[i][0]=='O'){
            dfs(i,0,vis,board,drow,dcol);
           }
           if(vis[i][n-1]==0 && board[i][n-1]=='O'){
            dfs(i,n-1,vis,board,drow,dcol);
           }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    static void dfs(int row , int col , int [][] vis , char[][] board , int [] drow , int [] dcol){
        vis[row][col] = 1;
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<4;i++){
            int nrow = row + drow[i];
            int ncol = col +dcol[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && board[nrow][ncol]=='O'){
                dfs(nrow,ncol , vis, board , drow , dcol);
            }
        }
    }
}