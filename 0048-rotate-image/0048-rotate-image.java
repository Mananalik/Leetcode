class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
      
            for(int j=0;j<n;j++){
                  for(int i=0;i<j;i++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                
            }
        }
        for(int it[]: matrix){
            rev(it);
        }
    }
    public void rev(int[] arr){
        int ptr1 = 0;
        int ptr2 = arr.length-1;
        while(ptr1<ptr2){
            int temp = arr[ptr1];
            arr[ptr1] = arr[ptr2];
            arr[ptr2] = temp;
            ptr1++;
            ptr2--;
        }
    }
}