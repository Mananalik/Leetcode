class Pair{
    int row;
    int col;
    Pair(int row , int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int vis[][]  = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        int originalcolour = image[sr][sc];
        if(originalcolour==color){
            return image;
        }
        q.add(new Pair(sr,sc));
        image[sr][sc] = color;
        vis[sr][sc] = 1;
        int drow[] = {-1,0,+1,0};
        int dcol[] = {0,+1,0,-1};
        while(!q.isEmpty()){
           int r = q.peek().row;
           int c=  q.peek().col;
           q.remove();
           for(int i=0;i<4;i++){
            int nrow = r+drow[i];
            int ncol = c+dcol[i];  
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && image[nrow][ncol]==originalcolour){
                q.add(new Pair(nrow,ncol));
                vis[nrow][ncol] = 1;
                image[nrow][ncol] = color;
            }
           }
        }
        return image;
    }
}