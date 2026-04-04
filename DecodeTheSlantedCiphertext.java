//approach 1
class Solution {
    public String decodeCiphertext(String text, int rows) {
        int n=text.length();
        if(rows==0) return "";

        int columns=n/rows;
        int i=0,j=0;
        StringBuilder sb=new StringBuilder();
        char matrix[][]=new char[rows][columns];
        int k=0;

        for(int r=0;r<rows;r++){
            for(int c=0;c<columns;c++){
                matrix[r][c]=text.charAt(k);
                k++;
            }
        }

        for(int col=0;col<columns;col++){
            i=0;
            j=col;

            while(i<rows && j<columns){
                sb.append(matrix[i][j]);
                i++;
                j++;
            }
        }

        while(sb.length()>0 && sb.charAt(sb.length()-1)==' '){
             sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}

//approach 2
class Solution {
    public String decodeCiphertext(String text, int rows) {
        int n=text.length();
        if(rows==0) return "";

        int columns=n/rows;
        StringBuilder sb=new StringBuilder();

        for(int col=0;col<columns;col++){
            for(int j=col;j<n;j+=(columns+1)){
                sb.append(text.charAt(j));
            }
        }

        while(sb.length()>0 && sb.charAt(sb.length()-1)==' '){
             sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}
