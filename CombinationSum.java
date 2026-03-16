class Solution {
    List<List<Integer>>result=new ArrayList<>();
    void solve(int [] candidates,int idx,int target,List<Integer>curr){
        if(idx>=candidates.length){
            if(target==0){
                result.add(new ArrayList<>(curr));
                return;
            }
            return;
        }

        if(candidates[idx]<=target){
            curr.add(candidates[idx]);
            solve(candidates,idx,target-candidates[idx],curr);
            curr.remove(curr.size()-1);
        }
        solve(candidates,idx+1,target,curr);        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer>curr=new ArrayList<>();
        solve(candidates,0,target,curr);

        return result;
    }
}
