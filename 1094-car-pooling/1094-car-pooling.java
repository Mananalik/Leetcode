class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b)->a[1]-b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[2]-b[2]);
        int curr = 0;
        for(int trip[]: trips){
            while(!pq.isEmpty() && pq.peek()[2]<=trip[1]){
                curr-=pq.poll()[0];
            }
            curr+=trip[0];
            if(curr>capacity) return false;
            pq.add(trip);
        }
        return true;
    }
}