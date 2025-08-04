class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int m = intervals.length;

        List<int[]> list = new ArrayList<>();
        int i=0;
        while(i<m && intervals[i][1]<newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        while(i<m && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        list.add(newInterval); 
        while(i<m){
            list.add(intervals[i]);
            i++;
        }
        int x = list.size();
        int [][] ans = new int[x][];
        for(int j=0;j<list.size();j++){
            ans[j]= list.get(j);
        }
        return ans;
    }
}