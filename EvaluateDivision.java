class Solution {
    record Pair(String b,double val){}
    double ans;
    public void dfs(String src,String dst,double prd,Set<String>visited,Map<String,ArrayList<Pair>>mp){
        if(visited.contains(src)){
            return;
        }
        visited.add(src);

        if(src.equals(dst)){
            ans=prd;
            return;
        }

        for(Pair p:mp.get(src)){
            String v=p.b();
            double value=p.val();

            dfs(v,dst,prd*value,visited,mp);
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n=equations.size();
        int m=queries.size();
        Map<String,ArrayList<Pair>>mp=new HashMap<>();

        for(int i=0;i<n;i++){
            String u=equations.get(i).get(0);
            String v=equations.get(i).get(1);
            double a=values[i];

            mp.putIfAbsent(u,new ArrayList<Pair>());
            mp.putIfAbsent(v,new ArrayList<Pair>());

            mp.get(u).add(new Pair(v,a));
            mp.get(v).add(new Pair(u,1.0/a));
        }

        double[] result=new double[m];
        int j=0;
       
        for(List<String>qu:queries){
            String src=qu.get(0);
            String dst=qu.get(1);

            ans=-1.0;
            double prd=1.0;

            if(mp.containsKey(src)){
                Set<String>visited=new HashSet<>();
                dfs(src,dst,prd,visited,mp);
            }
            result[j]=ans;
            j++;
        }

        return result;

    }
}
