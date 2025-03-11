class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr1 = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i!=0) arr.add(nums[i]);
            if(i!=n-1) arr1.add(nums[i]);
        }
        return Math.max(func(arr),func(arr1));
    }
    static int func(ArrayList<Integer> arr){
        int n = arr.size();
       int prev = arr.get(0);
       int prev2 = 0;
        for(int i=1;i<n;i++){
            int pick = arr.get(i);
            if(i>1) pick+=prev2;
            int notPick = prev;
            int curi = Math.max(pick,notPick);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
}