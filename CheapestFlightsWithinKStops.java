class Solution {
    record Pair(int node,int weight){}
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,ArrayList<Pair>>adj=new HashMap<>();

        Queue<Pair>qu=new LinkedList<>();
        int [] distance=new int[n];

        Arrays.fill(distance,Integer.MAX_VALUE);

        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }

        for(int flight[]: flights){
            int u=flight[0];
            int v=flight[1];
            int cost=flight[2];

            adj.get(u).add(new Pair(v,cost));
        }

        qu.offer(new Pair(src,0));
        distance[src]=0;
        int steps=0;

        while(!qu.isEmpty() && steps<=k){
            int N=qu.size();
            while(N>0){
                Pair p=qu.poll();
                int u=p.node();
                int w=p.weight();

                for(Pair it:adj.get(u)){
                    int v=it.node();
                    int cost=it.weight();

                    if(distance[v]>w+cost){
                        distance[v]=w+cost;
                        qu.offer(new Pair(v,w+cost));
                    }
                }
                N--;
            }
            steps++;
        }
        if(distance[dst]==Integer.MAX_VALUE){
            return -1;
        }

        return distance[dst];
    }
}
