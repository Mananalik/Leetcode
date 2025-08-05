class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int []a , int[] b){
                return a[1]-b[1];
            }
        });
        int n = intervals.length;
        int cnt = 1;
        int last = intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0]>=last){
                cnt++;
                last = intervals[i][1];
            }
        }
        return n-cnt;
    }
}