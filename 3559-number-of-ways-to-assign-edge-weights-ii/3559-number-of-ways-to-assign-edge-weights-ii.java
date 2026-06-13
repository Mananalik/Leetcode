class Solution {
    int log = 17;
    int [][] up;
    int [] depth;
    int mod =(int) (1e9+7);
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length+1;
        up = new int[n+1][log];
        depth = new int[n+1];
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int arr[]: edges){
            int u = arr[0];
            int v = arr[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs(1,1,0,adj);
        for(int i=1;i<log;i++){
            for(int j = 1;j<=n;j++){
                up[j][i] = up[up[j][i-1]][i-1];
            }
        }
        int ans[] = new int[queries.length];
        int x = 0;
        for(int arr[]: queries){
            int u = arr[0];
            int v = arr[1];
            int lca = getLCA(u,v);
            int L = depth[u]+depth[v] - 2*depth[lca];
            if(L==0){
                 ans[x] =  0;
                 x++;}
            if(L>0){ 
                ans[x] =helper(2,L-1);
            x++;
            }
        }
        return ans;
    }
    public void dfs(int node ,int parent, int d , List<List<Integer>> adj){
        up[node][0] = parent;
        depth[node] = d;
        for(int nodes: adj.get(node)){
            if(nodes!=parent){
                dfs(nodes,node,d+1,adj);
            }
        }
    }
    public int getLCA(int u, int v){
        if(depth[u]<depth[v]){
            int temp = u;
            u = v;
            v = temp;
        }
        for(int i=log-1;i>=0;i--){
            if(depth[u]-(1<<i)>=depth[v]){
                u = up[u][i];
            }
        }
        if(u==v) return u;
        for(int i=log-1;i>=0;i--){
            if(up[u][i]!=up[v][i]){
                u = up[u][i];
                v = up[v][i];
            }
        }
        return up[u][0];
    }
    private int helper(long base , long exp){
        long res = 1;
        base = base%mod;
        while(exp>0){
            if(exp%2==1){
                res = (res*base)%mod;
            }
            base = (base*base)%mod;
            exp/=2;
        }
        return (int) res;
    }

}