class Solution {
    record Pair(int row,int col){}
    int directions[][]={{1,0},{0,1},{-1,0},{0,-1}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int m=maze.length;
        int n=maze[0].length;

        Queue<Pair>qu=new LinkedList<>();

        qu.offer(new Pair(entrance[0],entrance[1]));
        maze[entrance[0]][entrance[1]]='.';

        int steps=0;

        while(!qu.isEmpty()){
            int l=qu.size();
            while(l>0){
                Pair p=qu.poll();
                int r=p.row();
                int c=p.col();
                if((r!=entrance[0] || c!=entrance[1]) && (r==0 || r==m-1 || c==0 || c==n-1)){
                    return steps;
                }

                //explore
                for(int [] dir:directions){
                    int i_=dir[0]+r;
                    int j_=dir[1]+c;

                    if(i_>=0 && j_>=0 && i_<m && j_<n && maze[i_][j_]!='+'){
                        qu.offer(new Pair(i_,j_));
                        maze[i_][j_]='+';
                    }
                }
                l--;
            }
            steps++;
        }
        return -1;
    }
}
