class Solution {
    public int totalFruit(int[] fruits) {

        // optimized version
        
        int n = fruits.length;
        int l=0;
        int r=0;
        int maxLen=0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        while(r<n){
            if(!mp.containsKey(fruits[r])){
                mp.put(fruits[r],1);
            }else{
                mp.put(fruits[r],mp.get(fruits[r])+1);
            }
            if(mp.size()>2){

                    mp.put(fruits[l],mp.get(fruits[l])-1);
                    if(mp.get(fruits[l])==0){
                        mp.remove(fruits[l]);
                    }
                    l++;
                
            }
            if(mp.size()<=2){
                int len = r-l+1;
                maxLen = Math.max(len,maxLen);
            }
            r++;
        }
        return maxLen;

        // Brute Force 

        // int n = fruits.length;
        // int maxLen = 0;
        // for(int i=0;i<n;i++){
        //     Set<Integer> st = new HashSet<>();
        //     for(int j=i;j<n;j++){
        //         st.add(fruits[j]);
        //         if(st.size()<=2){
        //             int len = j-i+1;
        //             maxLen = Math.max(len,maxLen);
        //         }else{
        //             break;
        //         }
        //     }
        // }
        // return maxLen;
    }
}