class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int vis[][] = new int[m][n]; 
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==j && vis[i][j]==0) vis[i][j]=1;
                else if (vis[i][j]==0){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                    vis[i][j] = 1;
                    vis[j][i] = 1;
                }
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