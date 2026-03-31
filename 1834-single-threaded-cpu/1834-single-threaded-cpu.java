class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int arr[][] = new int[n][3];
        for(int i=0;i<tasks.length;i++){
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]==b[1]?a[2]-b[2]:a[1]-b[1]);
        int time = 0;
        int i=0;
        int idx = 0;
        int res[] = new int[n];
        while(i<n || !pq.isEmpty()){
            if(pq.isEmpty()) time  = Math.max(time,arr[i][0]);
            while(i<n && arr[i][0]<=time){
                pq.add(arr[i]);
                i++;
            }
            int ans[] = pq.poll();
            time+=ans[1];
            res[idx++] = ans[2];
        }
        return res;
    }
}