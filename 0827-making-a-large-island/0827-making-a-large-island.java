class DisjointState{
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    public DisjointState(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findUpar(int node){
        if(parent.get(node)==node){
            return node;
        }
        int upar = findUpar(parent.get(node));
        parent.set(node,upar);
        return parent.get(node);
    }
        public void unionBySize(int u, int v) {
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    static boolean isValid(int newr , int newc , int n){
        return newr>=0 && newr<n && newc>=0 && newc<n;
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointState ds = new DisjointState(n*n);
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==0){
                    continue;
                }
                int drow[] = {-1,0,+1,0};
                int dcol[] = {0,+1,0,-1};
                for(int i=0;i<4;i++){
                    int newr = row + drow[i];
                    int newc = col + dcol[i];
                    if(isValid(newr,newc,n) && grid[newr][newc]==1){
                        int node= row*n +col;
                        int adjNode = newr*n+ newc;
                        ds.unionBySize(node,adjNode);
                    }
                }
            }
        }
        // step 2;
       int mx = 0;
       for(int row=0;row<n;row++){
        for(int col=0;col<n;col++){
            if(grid[row][col]==1){
                continue;
            }
            int drow[] = {-1,0,+1,0};
            int dcol[] = {0,+1,0,-1};
            HashSet<Integer> st = new HashSet<>();
            for(int i=0;i<4;i++){
                int newr = row+drow[i];
                int newc = col + dcol[i];
                if(isValid(newr,newc,n)){
                    if(grid[newr][newc]==1){
                        st.add(ds.findUpar(newr*n+newc));
                    }
                }
            }
            int sizeTotal = 0;
            for(Integer parent : st){
                sizeTotal+=ds.size.get(parent);
            }
            mx = Math.max(mx,sizeTotal+1);
        }
       }
        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            mx = Math.max(mx, ds.size.get(ds.findUpar(cellNo)));
        }
       return mx;
    }
}