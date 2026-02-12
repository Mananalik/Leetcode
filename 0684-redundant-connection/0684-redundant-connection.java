class DisjointSet{
    int parents[];
    int size[];
    DisjointSet(int n){
        parents = new int[n+1];
        size = new int[n+1];
        for(int i=1;i<=n;i++){
            parents[i]=i;
            size[i] = 1;
        }
    }
    public int find(int node){
        if(parents[node]==node){
            return node;
        }
        return parents[node] = find(parents[node]);
    }
    public void union(int u, int v){
        int up = find(u);
        int uv = find(v);
        if(up==uv) return;
        if(size[uv]>size[up]){
            parents[up] = uv;
            size[uv] = size[up]+size[uv];
        }
        else{
            parents[uv] = up;
            size[up] = size[up]+size[uv];
        }
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n);
        int ans[] = new int[2];
        for(int arr[]: edges){
            int u = arr[0];
            int v = arr[1];
            if(ds.find(u)!=ds.find(v)){
                ds.union(u,v);
            }else{
                ans = new int[]{u,v};
            }
        }
        return ans;
    }
}
