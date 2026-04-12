class Solution {
    void dfs(int [][] graph,List<List<Integer>>result,List<Integer>temp,int u,int destination){
        temp.add(u);

        if(u==destination){
            result.add(new ArrayList<>(temp));
        }
        else{
            for(int v:graph[u]){
                dfs(graph,result,temp,v,destination);
            }
        }
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;

        int source=0;
        int target=n-1;

        List<List<Integer>>result=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();

        dfs(graph,result,temp,source,target);

        return result;
    }
}
