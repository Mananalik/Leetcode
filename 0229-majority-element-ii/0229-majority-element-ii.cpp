class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int el1 = 0;
        int el2 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        int n = nums.size();
        for(int i=0;i<n;i++){
            if(nums[i]!=el2 && cnt1==0){
                el1 = nums[i];
                cnt1++;
            }else if(nums[i]!=el1 && cnt2==0){
                el2 = nums[i];
                cnt2++;
            }else if(nums[i]==el1){
                cnt1++;
            }else if(nums[i]==el2){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        int target = (n/3)+1;
        for(int i=0;i<n;i++){
            if(nums[i]==el1) cnt1++;
            else if(nums[i]==el2) cnt2++;
        }
        vector<int> ans;
        if(cnt1>=target) ans.push_back(el1);
        if(cnt2>=target) ans.push_back(el2);
        return ans;
    }
};