class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minpq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        PriorityQueue<Integer> maxpq = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<profits.length;i++){
            minpq.add(new int[]{capital[i],profits[i]});
        }
        for(int i=0;i<k;i++){
            while(!minpq.isEmpty() &&  minpq.peek()[0]<=w){
                  maxpq.add(minpq.poll()[1]);
            }
            if(maxpq.isEmpty()) break;
            w+=maxpq.poll();
        }
        return w;
    }
}