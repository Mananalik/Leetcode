class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        List<Integer> pse = new ArrayList<>();
        List<Integer> nse = new ArrayList<>();
        findPse(arr,pse);
        findNse(arr,nse);
        long total = 0;
        int mod = (int) 1e9+7;
        for(int i=0;i<n;i++){
            int left = i-pse.get(i);
            int right = nse.get(i)-i;
            long contrib = (left * right) % mod;
            contrib = (contrib * arr[i]) % mod;
            total = (total + contrib) % mod;
        }
        return  (int) total;
    }
    static void findPse(int arr[],List<Integer> pse){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                pse.add(-1);
            }else{
                pse.add(st.peek());
            }
            st.push(i);
        }
    }
    static void findNse(int arr[],List<Integer> nse){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int nums [] = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                nums[i] = n;
            }else{
                nums[i] = st.peek();
            }
            st.push(i);
        }
        for(int i=0;i<n;i++){
            nse.add(nums[i]);
        }
    }
}