class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        List<Integer>result=new ArrayList<>();

        for(int i=0;i<n;i++){
            int idx=Math.abs(nums[i])-1;

            if(nums[idx]>0){
                //mark it as negative
                nums[idx]=-1*nums[idx];
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }

        return result;
    }
}
