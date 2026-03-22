//1st approach
class Solution {
    private boolean traverse(int sr,int sc,int er,int ec,char [][] board){
        HashSet<Character>st=new HashSet<>();

        for(int i=sr;i<=er;i++){
            for(int j=sc;j<=ec;j++){
                if(board[i][j]=='.') continue;
                
                if(st.contains(board[i][j])){
                    return false;
                }
                st.add(board[i][j]);
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        
        for(int i=0;i<9;i++){
            Set<Character>st=new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(st.contains(board[i][j])){
                    return false;
                }
                st.add(board[i][j]);
            }
        }
        for(int j=0;j<9;j++){
            Set<Character>st=new HashSet<>();
            for(int i=0;i<9;i++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(st.contains(board[i][j])){
                    return false;
                }
                st.add(board[i][j]);
            }
        }

        for(int sr=0;sr<9;sr=sr+3){
            int er=sr+2;
            for(int sc=0;sc<9;sc=sc+3){
                int ec=sc+2;
                if(!traverse(sr,sc,er,ec,board)){
                    return false;
                }
            }
        }

        return true;
    }
}

//2nd approach
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String>st=new HashSet<>();
        for(int i=0;i<9;i++){
            
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                String row=String.valueOf(board[i][j])+"_ROW_"+String.valueOf(i);
                String col=String.valueOf(board[i][j])+"_COL_"+String.valueOf(j);
                String box=String.valueOf(board[i][j])+"_BOX_"+String.valueOf(i/3)+String.valueOf(j/3);

                if(st.contains(row) || st.contains(col) || st.contains(box)){
                    return false;
                }
                st.add(row);
                st.add(col);
                st.add(box);
            }
        }

        return true;
    }
}
