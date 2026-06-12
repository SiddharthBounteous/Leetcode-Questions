class Solution {
    private boolean solve(int idx,String s,int n,Set<String>st,Boolean [] t){
        if(idx>=n){
            return true;
        }
        if(t[idx]!=null){
            return t[idx];
        }

        if(st.contains(s)){
            return t[idx]=true;
        }

        for(int i=idx+1;i<=n;i++){
            String temp=s.substring(idx,i);

            if(st.contains(temp) && solve(i,s,n,st,t)){
                return t[idx]=true;
            }
        }
        return t[idx]=false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        Boolean [] t=new Boolean[n];
        Set<String> st=new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            st.add(wordDict.get(i));
        }

        return solve(0,s,n,st,t);
    }
}
