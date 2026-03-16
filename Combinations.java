class Solution {
    List<List<Integer>>result=new ArrayList<>();
    void solve(int n,int k,List<Integer>curr,int start){
        if(k==0){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(start>n){
            return;
        }
        curr.add(start);
        solve(n,k-1,curr,start+1);
        curr.remove(curr.size()-1);
        solve(n,k,curr,start+1);
    }
    public List<List<Integer>> combine(int n, int k) {
        int start=1;
        
        solve(n,k,new ArrayList<>(),start);

        return result;
    }
}
