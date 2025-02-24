class Tuple{
    int distance;
    int row;
    int col;
    Tuple(int distance , int row , int col){
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x,y)-> x.distance-y.distance);
        int dist[][] = new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    dist[i][j] = (int)1e9;
                }
            }
        dist[0][0] = 0;
        pq.add(new Tuple(0,0,0));
        int drow[] = {-1,0,+1,0};
        int dcol[] = {0,+1,0,-1};
        while(!pq.isEmpty()){
            Tuple it = pq.poll();
            int distance  = it.distance;
            int r = it.row;
            int c = it.col;
            if(r==m-1 && c==n-1){
                return distance;
            }
            for(int i=0;i<4;i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n){
                    int maxEffort = Math.max(Math.abs(heights[r][c]-heights[nrow][ncol]),distance);
                    if(maxEffort<dist[nrow][ncol]){
                        dist[nrow][ncol] = maxEffort;
                        pq.add(new Tuple(maxEffort , nrow,ncol));
                    }
                }
            }
        }
        return 0;
    }
}