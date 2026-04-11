class Solution {
    public void dfs(boolean [] visited,List<List<Integer>> rooms,int source){
        visited[source]=true;

        for(int node:rooms.get(source)){
            if(!visited[node]){
                dfs(visited,rooms,node);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();

        boolean [] visited=new boolean[n];

        Arrays.fill(visited,false);

        dfs(visited,rooms,0);

        for(boolean it:visited){
            if(it==false){
                return false;
            }
        }

        return true;
    }
}
