class Solution {
    public int rotatedDigits(int n) {
        int cnt = 0;
        for(int i = 1;i<=n;i++){

            if(i<10){
                if(i==2 || i==5 || i==6 || i==9){
                    cnt++;
                }
            }
            else{
                boolean isValid = true;
                boolean isChanged = false;
                int x = i;
                while(x!=0){
                    int num = x%10;
                    if(num==7 || num==3 || num==4){
                        isValid = false;
                        break;
                    } 
                    if(num==2 || num==5 || num==6 || num==9){
                        isChanged = true;
                    }
                    
                    x = x/10;
                }
                if(isValid==true && isChanged==true) cnt++;
            }
        }
        return cnt;
    }
}