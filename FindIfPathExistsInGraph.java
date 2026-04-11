//dfs
class Solution {
    boolean dfs(int s,int d,Map<Integer,ArrayList<Integer>> mp, boolean [] visited){
        if(s==d){
            return true;
        }

        if(visited[s]==true){
            return false;
        }

        visited[s]=true;

        for(int node : mp.get(s)){
            if(dfs(node,d,mp,visited)==true){
                return true;
            }
        }

        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer,ArrayList<Integer>> mp=new HashMap<>();

        for(int [] edge: edges){
            int u=edge[0];
            int v=edge[1];

            mp.putIfAbsent(u,new ArrayList<>());
            mp.putIfAbsent(v,new ArrayList<>());

            mp.get(u).add(v);
            mp.get(v).add(u);
        }

        boolean [] visited=new boolean[n];

        Arrays.fill(visited,false);
        return dfs(source,destination,mp,visited);
    }
}

//bfs
class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer,ArrayList<Integer>> mp=new HashMap<>();

        for(int [] edge: edges){
            int u=edge[0];
            int v=edge[1];

            mp.putIfAbsent(u,new ArrayList<>());
            mp.putIfAbsent(v,new ArrayList<>());

            mp.get(u).add(v);
            mp.get(v).add(u);
        }

        boolean [] visited=new boolean[n];

        Arrays.fill(visited,false);
        
        Queue<Integer>qu=new LinkedList<>();
        qu.offer(source);

        while(!qu.isEmpty()){
            int node=qu.poll();

            if(node==destination){
                return true;
            }

            for(int v:mp.get(node)){
                if(visited[v]==false){
                    qu.offer(v);
                    visited[v]=true;
                }
            }

        }
        return false;
    }
}
