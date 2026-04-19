class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target){
            return 0;
        }
        int n=routes.length;
        Map<Integer,ArrayList<Integer>>adj=new HashMap<>();

        for(int route=0;route<n;route++){
            
            for(int stop:routes[route]){
                adj.putIfAbsent(stop,new ArrayList<>());
                adj.get(stop).add(route);
            }
        }

        if(!adj.containsKey(source) || !adj.containsKey(target)){
            return -1;
        }

        boolean [] visited=new boolean[n];
        Arrays.fill(visited,false);

        Queue<Integer>qu=new LinkedList<>();

        for(int route:adj.get(source)){
            qu.offer(route);
            visited[route]=true;
        }

        int bus=1;

        while(!qu.isEmpty()){
            int N=qu.size();

            while(N>0){
                int route=qu.poll();

                for(int stop:routes[route]){
                    if(stop==target){
                        return bus;
                    }

                    for(int nextRoute:adj.get(stop)){
                        if(visited[nextRoute]==false){
                            visited[nextRoute]=true;
                            qu.offer(nextRoute);
                        }
                    }
                }
                N--;
            }
            bus++;
        }

        return -1;
    }
}
