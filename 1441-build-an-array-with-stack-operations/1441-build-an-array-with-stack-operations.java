class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int idx = 0;
        for(int i=1;i<=n;i++){
            if(idx==target.length) break;
            else{
                if(i == target[idx]){
                    ans.add("Push");
                    idx++;
                }else{
                    ans.add("Push");
                    ans.add("Pop");
                }
            }
        }
        return ans;
    }
}