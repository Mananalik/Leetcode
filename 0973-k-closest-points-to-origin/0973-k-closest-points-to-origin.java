class Solution {
    class Pair{
        int dist;
        int row;
        int col;
        Pair(int d , int r , int c){
            dist = d;
            row = r;
            col = c;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.dist-a.dist);
        for(int [] arr: points){
            int dist = arr[0]*arr[0] + arr[1]*arr[1];
            pq.add(new Pair(dist,arr[0],arr[1]));
            if(pq.size()>k){
                pq.poll();
            }
        }
        int ans[][] = new int[k][2];
        for(int i=0;i<k;i++){
            Pair p = pq.poll();
            ans[i][0] = p.row;
            ans[i][1] = p.col;
        }
        return ans;
    }
}
