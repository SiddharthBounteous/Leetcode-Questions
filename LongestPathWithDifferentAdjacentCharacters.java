class Solution {
    int result;
    public int dfs(Map<Integer,ArrayList<Integer>>adj,int currNode,int parentNode,String s){
        int longest=0;
        int second_longest=0;

        for(int child:adj.get(currNode)){
            if(child==parentNode){
                continue;
            }

            int child_longest_length=dfs(adj,child,currNode,s);

            if(s.charAt(child)==s.charAt(currNode)){
                continue;
            }

            if(child_longest_length>second_longest){
                second_longest=child_longest_length;
            }
            if(second_longest>longest){
                int temp=second_longest;
                second_longest=longest;
                longest=temp;
            }
        }

        int koi_ek_accha=Math.max(longest,second_longest)+1;
        int only_root_accha=1;
        int neeche_hi_ans=1+longest+second_longest;

        result=Math.max(result,Math.max(koi_ek_accha,Math.max(only_root_accha,neeche_hi_ans)));

        return Math.max(koi_ek_accha,only_root_accha);
    }
    public int longestPath(int[] parent, String s) {
        int n=parent.length;

        Map<Integer,ArrayList<Integer>>adj=new HashMap<>();
        result=0;

        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }

        for(int i=1;i<n;i++){
            int u=i;
            int v=parent[i];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        dfs(adj,0,-1,s);

        return result;
    }
}
