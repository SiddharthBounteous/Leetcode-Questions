class Solution {
    int m,n;
    record Pair(int first,int sec){}
    int [][] directions={{1,0},{0,1},{-1,0},{0,-1}};
    private boolean isSafe(int i,int j){
        return i>=0 && j>=0 && i<m && j<n;
    }
    private void dfs(int[][] grid,int i,int j,Set<Pair>visited){
        if(!isSafe(i,j) || grid[i][j]==0 || visited.contains(new Pair(i,j))){
            return;
        }

        visited.add(new Pair(i,j));

        for(int [] dir:directions){
            int i_=i+dir[0];
            int j_=j+dir[1];

            if(isSafe(i_,j_) && grid[i_][j_]==1 && !visited.contains(new Pair(i_,j_))){
                dfs(grid,i_,j_,visited);
            }
        }
    }
    private int bfs(int[][] grid,Set<Pair>visited){
        Queue<Pair>qu=new LinkedList<>();

        for(Pair it:visited){
            int i=it.first();
            int j=it.sec();

            qu.add(new Pair(i,j));
        }

        int level=0;
        while(!qu.isEmpty()){
            int l=qu.size();

            while(l>0){
                Pair curr=qu.poll();
                int x=curr.first();
                int y=curr.sec();

                for(int [] dir:directions){
                    int x_=x+dir[0];
                    int y_=y+dir[1];

                    if(isSafe(x_,y_) && !visited.contains(new Pair(x_,y_))){
                        if(grid[x_][y_]==1){
                            //we found second island
                            return level;
                        }
                        visited.add(new Pair(x_,y_));
                        qu.offer(new Pair(x_,y_));
                    }
                }
                l--;
            }
            level++;
        }
        return level;
    }
    public int shortestBridge(int[][] grid) {
        m=grid.length;
        n=grid[0].length;

        Set<Pair>visited=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,visited);   //mark all cell with 1's as visited
                    return bfs(grid,visited);
                }
            }
        }
        return -1;
    }
}
