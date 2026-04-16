class Solution {
    public void dfs(int u,Set<Integer>visited,Map<Integer,ArrayList<Integer>>mp){
        visited.add(u);

        for(int v:mp.getOrDefault(u,new ArrayList<>())){
            if(!visited.contains(v)){
                dfs(v,visited,mp);
            }
        }
    }
    public int maximumDetonation(int[][] bombs) {
        int n=bombs.length;

        Map<Integer,ArrayList<Integer>>mp=new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }

                long x1=bombs[i][0];
                long y1=bombs[i][1];
                long r1=bombs[i][2];

                long x2=bombs[j][0];
                long y2=bombs[j][1];
                long r2=bombs[j][2];

                long distance=(x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);

                if(r1*r1>=distance){
                    mp.putIfAbsent(i,new ArrayList<>());
                    mp.get(i).add(j);
                }
            }
        }
        int result=0;
        

        for(int i=0;i<n;i++){
            Set<Integer>visited=new HashSet<>();
            dfs(i,visited,mp);
            int count=visited.size();
            result=Math.max(result,count);
        }
        return result;
    }
}
