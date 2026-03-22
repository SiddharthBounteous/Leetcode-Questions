class Solution {
    private int findLive(int i,int j,int[][] board,int n,int m){
        int live=0;

        if(i+1<n && board[i+1][j]==1) live++;
        if(j+1<m && board[i][j+1]==1) live++;
        if(i-1>=0 && board[i-1][j]==1) live++;
        if(j-1>=0 && board[i][j-1]==1) live++;

        if(i+1<n && j+1<m && board[i+1][j+1]==1) live++;
        if(i+1<n && j-1>=0 && board[i+1][j-1]==1) live++;
        if(i-1>=0 && j+1<m && board[i-1][j+1]==1) live++;
        if(i-1>=0 && j-1>=0 && board[i-1][j-1]==1) live++;

        return live;
    }
    public void gameOfLife(int[][] board) {
        int n=board.length;
        int m=board[0].length;
        int clone[][]=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                clone[i][j]=board[i][j];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(clone[i][j]==1){
                    int live=findLive(i,j,clone,n,m);
                    if(live==2 || live==3){
                        board[i][j]=1;
                    }
                    else{
                        board[i][j]=0;
                    }
                }
                else{
                    if(findLive(i,j,clone,n,m)==3){
                        board[i][j]=1;
                    }
                    else{
                        board[i][j]=0;
                    }
                }
            }
        }


    }
}
