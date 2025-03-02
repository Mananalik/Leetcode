class DisjointSet{
    ArrayList<Integer> parent = new ArrayList<Integer>();
    ArrayList<Integer> rank = new ArrayList<Integer>();
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            rank.add(0);
        }
    }
    public int findUpar(int node){
        if(node==parent.get(node)){
            return node;
        }
        int ulp = findUpar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void unionByRank(int u , int v){
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);
        if(ulp_u==ulp_v){
           return;
        }
       else if(rank.get(ulp_u)<rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }
        else if(rank.get(ulp_v)<rank.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
        }else{
             parent.set(ulp_v,ulp_u);
             int rankU = rank.get(ulp_u);
             rank.set(ulp_u,rankU+1);
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int m = connections.length;
        int cntExtras = 0;
        for(int i=0;i<m;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            if(ds.findUpar(u)==ds.findUpar(v)){
                cntExtras++;
            }
            else{
                ds.unionByRank(u,v);
            }
        }
        int cntC = 0;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i){
                cntC++;
            }
        }
        int ans = cntC-1;
        if(cntExtras>=ans){
            return ans;
        }
        return -1;
    }
}