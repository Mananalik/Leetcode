class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        int degree[] = new int [V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int x[]: prerequisites){
            adj.get(x[1]).add(x[0]);
        }
        for(int i=0;i<V;i++){
            for(int it: adj.get(i)){
                degree[it]++;
            }
        }
        int topo[] = new int[V];
        Queue<Integer> q = new LinkedList<>();
         for(int i=0;i<V;i++){
            if(degree[i]==0){
                q.add(i);
            }
         }
         int j=0;
         while(!q.isEmpty()){
            int node = q.peek();
            topo[j++] = node;
            for(int it: adj.get(node)){
                degree[it]--;
                if(degree[it]==0){
                    q.add(it);
                }
            }
            q.remove();
         }
  
    return (j==V)?topo:new int[]{};
    }
}