class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //  Set<List<Integer>> st = new HashSet<>();
        
        // int n = nums.length;
        // for(int i = 0;i<n;i++){
        //     Set<Integer> hash = new HashSet<>();
        //     for(int j=i+1;j<n;j++){
        //         int temp =-(nums[i]+nums[j]);
        //         if(hash.contains(temp)){
        //             List<Integer> list2 = Arrays.asList(nums[i],nums[j],temp);
        //             list2.sort(null);
        //              st.add(list2);
        //         }
        //         hash.add(nums[j]);
        //     }
         
        // }
        // List<List<Integer>> list1 = new ArrayList<>(st);
        // return list1;

        // 2nd Mehod (Optimal approach)
        List<List<Integer>> list = new ArrayList<>();
        int n  = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else{
                    List<Integer> list1 = Arrays.asList(nums[i],nums[j],nums[k]);
                    list.add(list1);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]){
                        j++;
                    }
                     while(j<k && nums[k]==nums[k+1]){
                        k--;
                    }
                }
            }
        }
        return list;
    }
}