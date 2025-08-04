class Solution {
    public int candy(int[] ratings) {
        // int n = ratings.length;
        // int cnt=0;
        // int left[] = new int [n];
        // int right[] = new int[n];
        // left[0] = 1;
        // for(int i=1;i<n;i++){
        //     if(ratings[i]>ratings[i-1]){
        //         left[i]=  left[i-1]+1;
        //     }else{
        //         left[i] = 1;
        //     }
        // }
        // right[n-1]=1;
        // for(int i=n-2;i>=0;i--){
        //     if(ratings[i]>ratings[i+1]){
        //         right[i] = right[i+1]+1;
        //     }else{
        //         right[i] = 1;
        //     }
        // }
        // for(int i=0;i<n;i++){
        //     right[i] = Math.max(left[i],right[i]);
        //     cnt+=right[i];
        // }
        // return cnt;

        // optimized - slope method
        int n = ratings.length;
        int i=1;
        int sum = 1;
        while(i<n){
            if(ratings[i]==ratings[i-1]){
                sum=sum+1;
                i++;
                continue;
            }
            int peak = 1;
            while(i<n && ratings[i]>ratings[i-1]){
                peak+=1;
                sum=sum+peak;
                i++;
            }
            int down = 1;
            while(i<n && ratings[i]<ratings[i-1]){
                sum+=down;
                down+=1;
                
              
                i++;
            }
            if(peak<down){
                sum+=(down-peak);
            }
        }
        return sum;
    }
}