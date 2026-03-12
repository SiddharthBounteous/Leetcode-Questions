class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n= matrix.length;
        int m=matrix[0].length;

        int rowBegin=0;
        int colBegin=0;
        int rowEnd=n-1;
        int colEnd=m-1;

        List<Integer>result=new ArrayList<>();

        while(rowBegin<=rowEnd && colBegin<=colEnd){
            //Traverse right
            for(int j=colBegin;j<=colEnd;j++){
                result.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            //Traverse down
            for(int j=rowBegin;j<=rowEnd;j++){
                result.add(matrix[j][colEnd]);
            }
            colEnd--;

            //Traverse left
            if(rowBegin<=rowEnd){
                for(int j=colEnd;j>=colBegin;j--){
                    result.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            //Traverse up
            if(colBegin<=colEnd){
                for(int j=rowEnd;j>=rowBegin;j--){
                    result.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }
        return result;
    }
}
