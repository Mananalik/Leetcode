class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        int n = arr1.length;
        int maxi = 0;
        for(int i=0;i<n;i++){
            int num = arr1[i];
            while(num!=0){
                set.add(num);
                num = num/10;
            }
        }
        for(int i=0;i<arr2.length;i++){
            int num = arr2[i];
            while(num!=0){
                int x = num;
                if(set.contains(x)){
                int len = func(x);
                maxi = Math.max(maxi,len);
                break;
            }
            num = num/10;
            }
            
        }
        return maxi;
    }
    public int func(int num){
        int len = 0;
        while(num!=0){
            num=num/10;
            len++;
        }
        return len;
    }
}