class Solution {
    public void solve(List<Integer> temp,int idx,int[] nums,List<List<Integer>>result){
        if(idx>=nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        solve(temp,idx+1,nums,result);
        temp.remove(temp.size()-1);
        solve(temp,idx+1,nums,result);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer>temp=new ArrayList<>();
        List<List<Integer>>result=new ArrayList<>();

        solve(temp,0,nums,result);

        return result;
    }
}
