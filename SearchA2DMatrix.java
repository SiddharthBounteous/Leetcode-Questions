//approach 1
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;

        int i=0,j=m-1;

        while(i<n && j>=0){
            if(matrix[i][j]>target){
                j--;
            }
            else if(matrix[i][j]<target){
                i++;
            }
            else{
                return true;
            }
        }
        return false;
    }
}

//approach 2
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;

        int start=0;
        int end=m*n-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            if(matrix[mid/m][mid%m]>target){
                end=mid-1;
            }
            else if(matrix[mid/m][mid%m]<target){
                start=mid+1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
