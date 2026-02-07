class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int [][] pacific = new int[m][n];
        int [][] atlantic = new int[m][n];
        int drow[] = {-1,0,+1,0};
        int dcol[] = {0,+1,0,-1};
        List<List<Integer>> ans = new ArrayList<>();
        for(int j=0;j<n;j++){
            dfs(0,j,pacific,heights,heights[0][j],drow,dcol);
        }
        for(int i=0;i<m;i++){
            dfs(i,0,pacific,heights,heights[i][0],drow,dcol);
        }
        for(int j=0;j<n;j++){
            dfs(m-1,j,atlantic,heights,heights[m-1][j],drow,dcol);
        }
        for(int i=0;i<m;i++){
            dfs(i,n-1,atlantic,heights,heights[i][n-1],drow,dcol);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j]==1 && atlantic[i][j]==1){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
    public void dfs(int r , int c , int[][] visited,int[][] arr,int prevHeight, int drow[], int dcol[]){
        int m = arr.length;
        int n = arr[0].length;
        if(r<0 || c<0 || r>=m || c>=n){
            return;
        }
        if(visited[r][c]==1) return;
        if(arr[r][c]<prevHeight) return;
        visited[r][c]=1;
        for(int i=0;i<4;i++){
            int nr = r+drow[i];
            int nc = c + dcol[i];
            dfs(nr,nc,visited,arr,arr[r][c],drow,dcol);
        }
    }
}

