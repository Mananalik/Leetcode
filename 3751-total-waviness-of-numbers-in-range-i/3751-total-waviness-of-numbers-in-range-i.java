class Solution {
    long [][][][][] memoSum;
    long [][][][][] memoCount;
    public int totalWaviness(int num1, int num2) {

        int arr[] = new int[2];
        resetMemo();
        long upper[] = solve(0,-1,-1,1,0,String.valueOf(num2));
        resetMemo();
        long lower[] =solve(0,-1,-1,1,0,String.valueOf(num1-1));
        return (int) (upper[0] - lower[0]);
    }
    public void resetMemo(){
        memoSum = new long[20][11][11][2][2];
        memoCount = new long[20][11][11][2][2];
        for(int i=0;i<20;i++){
            for(int j=0;j<11;j++){
                for(int k=0;k<11;k++){
                    for(int l=0;l<2;l++){
                        for(int m=0;m<2;m++){
                            memoSum[i][j][k][l][m]=-1;
                            memoCount[i][j][k][l][m]=-1;
                        }
                    }
                }
            }
            
        }
    }
    public long[] solve(int index, int prev1 , int prev2 , int isTight, int hasStarted, String numStr){
        if(index==numStr.length()){
            return new long[]{0,1};
        }
        if(memoSum[index][prev1+1][prev2+1][isTight][hasStarted]!=-1 &&
           memoCount[index][prev1+1][prev2+1][isTight][hasStarted]!=-1){
            return new long [] {memoSum[index][prev1+1][prev2+1][isTight][hasStarted],memoCount[index][prev1+1][prev2+1][isTight][hasStarted]};
           }
        int limit = (isTight==1)? numStr.charAt(index)-'0':9;
        long totalSum = 0;
        long totalCount = 0;

        for(int i=0;i<=limit;i++){
            int nextIsTight = 0;
            int nextHasStarted = 0;
            int nextPrev1= -1;
            int nextPrev2 = -1;
            nextIsTight = (isTight==1 && i==limit)?1:0;
            nextHasStarted = (hasStarted==1 || i>0)? 1:0;
            if (nextHasStarted == 1) {
                nextPrev2 = prev1; 
                nextPrev1 = i;     
                }
            int isWavy = 0;
            if (hasStarted == 1 && prev1 != -1 && prev2 != -1) {
                if(prev1>prev2 && prev1>i) isWavy = 1;
                if(prev1<prev2 && prev1<i) isWavy = 1;
            }
            long[] nextRes = solve(index + 1, nextPrev1, nextPrev2, nextIsTight, nextHasStarted, numStr);

            totalCount += nextRes[1];
            totalSum += nextRes[0];
            if (isWavy == 1) {
                totalSum += nextRes[1];
                }
        }
        memoSum[index][prev1 + 1][prev2 + 1][isTight][hasStarted] = totalSum;
        memoCount[index][prev1 + 1][prev2 + 1][isTight][hasStarted] = totalCount;
        return new long [] {totalSum,totalCount};
    }
}