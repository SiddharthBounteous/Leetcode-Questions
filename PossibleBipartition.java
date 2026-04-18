class Solution {
    public boolean checkBipartite(int [] color,Map<Integer,ArrayList<Integer>>mp,int u){
        Queue<Integer>qu=new LinkedList<>();

        qu.offer(u);
        color[u]=1;

        while(!qu.isEmpty()){
            int node=qu.poll();

            for(int v:mp.get(node)){
                if(color[node]==color[v]){
                    return false;
                }

                if(color[v]==-1){
                    qu.offer(v);
                    color[v]=1-color[node];
                }
            }
        }

        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer,ArrayList<Integer>>mp=new HashMap<>();

        for(int i=1;i<=n;i++){
            mp.put(i, new ArrayList<>());
        }

        for(int [] it:dislikes){
            int u=it[0];
            int v=it[1];

            mp.get(u).add(v);
            mp.get(v).add(u);
        }

        int [] color=new int[n+1];

        Arrays.fill(color,-1);

        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                if(checkBipartite(color,mp,i)==false){
                    return false;
                }
            }
        }

        return true;
    }
}
