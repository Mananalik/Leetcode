class DisjointState {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointState(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUpar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUpar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
      DisjointState ds = new DisjointState(n);
      HashMap<String,Integer>map = new HashMap<String,Integer>();
      for(int i=0;i<n;i++){
        for(int j = 1;j<accounts.get(i).size();j++){
            String node = accounts.get(i).get(j);
            if(!map.containsKey(node)){
                map.put(node,i);
            }
            else{
                ds.unionByRank(i,map.get(node));
            }
        }
      }
      ArrayList<String>[] mergeMail = new ArrayList[n];
      for(int i=0;i<n;i++){
        mergeMail[i] = new ArrayList<>();
      }
        for(Map.Entry<String,Integer> it: map.entrySet()){
            String mail = it.getKey();
            int node = ds.findUpar(map.get(mail));
            mergeMail[node].add(mail);
        }
       List<List<String>> ans = new ArrayList<>();
       for(int i=0;i<n;i++){
        if(mergeMail[i].size()==0){
            continue;
        }
        Collections.sort(mergeMail[i]);
        List<String> temp = new ArrayList<>();
        temp.add(accounts.get(i).get(0));
        for(String it : mergeMail[i]){
            temp.add(it);
        }
        ans.add(temp);
       }
       return ans;
    }
}