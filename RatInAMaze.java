class Solution{
    int n,m;
    public void solve(int i,int j,int[][] maze,StringBuilder path,ArrayList<String>result){
        if(i<0 || j<0 || i>=n || j>=m || maze[i][j]==0){
            return;
        }

        if(i==n-1 && j==m-1){
            result.add(path.toString());
            return;
        }

        maze[i][j]=0;

        path.append('U');
        solve(i-1,j,maze,path,result);
        path.deleteCharAt(path.length()-1);

        path.append('R');
        solve(i,j+1,maze,path,result);
        path.deleteCharAt(path.length()-1);

        path.append('D');
        solve(i+1,j,maze,path,result);
        path.deleteCharAt(path.length()-1);

        path.append('L');
        solve(i,j-1,maze,path,result);
        path.deleteCharAt(path.length()-1);

        maze[i][j]=1;
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        n=maze.length;
        m=maze[0].length;
        ArrayList<String>result=new ArrayList<>();
        solve(0, 0, maze, new StringBuilder(),result);
        return result;
    }
}
