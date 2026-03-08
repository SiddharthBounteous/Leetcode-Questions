class Solution {
    private void solve(List<List<Integer>>result,int [] nums,ArrayList<Integer>temp){

        if(temp.size()==nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int num:nums){

            if(temp.contains(num)){
                continue;
            }
            temp.add(num);

            solve(result,nums,temp);

            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>result=new ArrayList<>();

        solve(result,nums,new ArrayList<>());

        return result;
    }
}
