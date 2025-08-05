class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[]a , int[]b){
                return a[0]-b[0];
            }
        });
        for(int i=0;i<n;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(!ans.isEmpty()){
                int temp[] = ans.get(ans.size()-1);
                if(end<=temp[1]){
                    continue;
                }
            }
            for(int j=i+1;j<n;j++){
                if(intervals[j][0]<=end){
                    end = Math.max(end,intervals[j][1]);
                }else{
                    break;
                }
            }
            int temp1[] = new int[2];
            temp1[0] = start;
            temp1[1] = end;
            ans.add(temp1);
        }
        int final1[][] = new int[ans.size()][];
        for(int i=0;i<ans.size();i++){
            final1[i] = ans.get(i);
        }
        return final1;
    }
}