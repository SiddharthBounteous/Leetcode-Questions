//by dfs
class Solution {
    public boolean isCycleDFS(boolean []visited,boolean [] inRecursion,int node,int [][] graph){
        visited[node]=true;
        inRecursion[node]=true;

        for(int v:graph[node]){
            if(visited[v]==false && isCycleDFS(visited,inRecursion,v,graph)){
                return true;
            }
            if(inRecursion[v]==true){
                return true;
            }
        }

        inRecursion[node]=false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;

        boolean [] visited=new boolean[n];
        boolean [] inRecursion=new boolean[n];
        List<Integer>safeNodes=new ArrayList<>();

        Arrays.fill(visited,false);
        Arrays.fill(inRecursion,false);

        for(int i=0;i<n;i++){
            if(!visited[i]){
                isCycleDFS(visited,inRecursion,i,graph);
            }
        }

        for(int i=0;i<n;i++){
            if(inRecursion[i]==false){
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
}
//by bfs
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;

        boolean [] isSafe=new boolean[n];
        Arrays.fill(isSafe,false);

        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int [] indegree=new int[n];

        Queue<Integer>qu=new LinkedList<>();

        for(int u=0;u<n;u++){
            for(int v:graph[u]){
                adj.get(v).add(u);
                indegree[u]++;
            }
        }

        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                qu.offer(i);
            }
        }

        while(!qu.isEmpty()){
            int u=qu.poll();
            isSafe[u]=true;
            
            for(int v:adj.get(u)){
                indegree[v]--;

                if(indegree[v]==0){
                    qu.offer(v);
                }
            }
        }

        List<Integer>safeNodes=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(isSafe[i]==true){
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
}
