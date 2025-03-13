class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();
        for(int i=0;i<m;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<triangle.get(i).size();j++){
                row.add(-1);
            }
            dp.add(row);
        }
        
        return func(0,0,triangle,dp);
    }

    // memoization
    static int func(int i , int j , List<List<Integer>> triangle, List<List<Integer>> dp){
        if(i==triangle.size()-1){
            return triangle.get(i).get(j);
        }
        if(dp.get(i).get(j)!=-1) return dp.get(i).get(j);
        int down = triangle.get(i).get(j) + func(i+1,j,triangle,dp);
        int dg = triangle.get(i).get(j) + func(i+1,j+1,triangle,dp);
        int min = Math.min(down,dg);
         dp.get(i).set(j,min);
         return min;
    }
}