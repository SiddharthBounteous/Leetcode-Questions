class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int res[]=new int[2];

        int i=0,j=n-1;

        while(i<j){
            if(nums[i]+nums[j]<target){
                i++;
            }
            else if(nums[i]+nums[j]>target){
                j--;
            }
            else{
                res[0]=i+1;
                res[1]=j+1;
                break;
            }
        }
        return res;
    }
}
