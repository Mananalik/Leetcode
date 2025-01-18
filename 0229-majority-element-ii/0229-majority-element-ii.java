class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        // int n = nums.length;
        //   int mini = (int)(n / 3) + 1;
        // for(int i=0;i<n;i++){
        //      map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        //     int count = map.getOrDefault(nums[i],0);
        //     if (count==mini){
        //         list.add(nums[i]);
        //     }
           
        // }
        // return list;
        
        // 2nd method optimal approach
        int n  = nums.length;
        int count1 =0;
        int el1 = Integer.MIN_VALUE;
        int count2 = 0;
        int el2 = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(count1==0 && el2!=nums[i]){
                count1 = 1;
                el1 = nums[i];
            }else if(count2==0 && el1!=nums[i]){
                count2 = 1;
                el2 = nums[i];
            }else if(el1==nums[i]){
                count1++;
            }else if(el2==nums[i]){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el1) cnt1++;
            if (nums[i] == el2) cnt2++;
        }
        int mini = (int)((n/3)+1);
        if(cnt1>=mini){
            list.add(el1);
        }
        if(cnt2>=mini){
            list.add(el2);
        }
        return list;
    }
}