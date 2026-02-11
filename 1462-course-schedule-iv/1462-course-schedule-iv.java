class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean reachable[][] = new boolean[n][n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int arr[]: prerequisites){
            int u = arr[0];
            int v = arr[1];
            adj.get(v).add(u);
            reachable[u][v] = true;
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(reachable[i][k] && reachable[k][j]){
                        reachable[i][j] = true;
                    }
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for(int arr[]: queries){
            int u = arr[0];
            int v = arr[1];
            ans.add(reachable[u][v]);
        }
        return ans;
        
    }
}