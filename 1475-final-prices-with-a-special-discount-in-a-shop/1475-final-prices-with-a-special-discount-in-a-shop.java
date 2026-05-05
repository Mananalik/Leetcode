class Solution {
    public int[] finalPrices(int[] prices) {
        int ans[] = new int[prices.length];
        for(int i=0;i<prices.length-1;i++){
            int j = i+1;
            while(j<prices.length){
                if(prices[j]<=prices[i]){
                    ans[i] = prices[i]-prices[j];
                    break;
                }else{
                    ans[i] = prices[i];
                }
                j++;
            }
        }
        ans[prices.length-1] = prices[prices.length-1];
        return ans;
    }
}