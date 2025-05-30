class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s=0;
        int e=findMax(piles);
        while(s<=e){
            int mid = s+(e-s)/2;
            int reqTime = func(piles,mid);
            if(reqTime<=h){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return s;
    }
    static int findMax(int piles[]){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            max = Math.max(max,piles[i]);
        }
        return max;
    }
    static int func(int piles[], int z){
        int totalTime = 0;
        for(int i=0;i<piles.length;i++){
            totalTime+=Math.ceil((double) piles[i]/(double) z);
        }
        return totalTime;
    }
}