class Solution {
    record Pair(int node,int weight){}
    int result=Integer.MAX_VALUE;
    void dfs(int u,Map<Integer,ArrayList<Pair>>mp, boolean[] visited){
        visited[u]=true;

        for(Pair p:mp.get(u)){
            int v=p.node();
            int w=p.weight();
            result=Math.min(result,w);

            if(!visited[v]){
                dfs(v,mp,visited);
            }
        }
    }
    public int minScore(int n, int[][] roads) {
        Map<Integer,ArrayList<Pair>>mp=new HashMap<>();

        for(int road[]:roads){
            int u=road[0];
            int v=road[1];
            int w=road[2];

            mp.putIfAbsent(u,new ArrayList<Pair>());
            mp.putIfAbsent(v,new ArrayList<Pair>());

            mp.get(u).add(new Pair(v,w));
            mp.get(v).add(new Pair(u,w));
        }

        boolean [] visited=new boolean[n+1];

        Arrays.fill(visited,false);


        dfs(1,mp,visited);

        return result;
    }
}
