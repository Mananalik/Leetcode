class Solution {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        for(int i=1;i<=numRows;i++){
          list.add(generateRows(i));
       }
       return list;
    }
    static List<Integer> generateRows(int r){
        List<Integer> list = new ArrayList<>();
        int ans = 1;
        list.add(ans);
        for(int i=1;i<r;i++){
            ans = ans*(r-i);
            ans = ans/i;
            list.add(ans);
        }
        return list;
    }
}