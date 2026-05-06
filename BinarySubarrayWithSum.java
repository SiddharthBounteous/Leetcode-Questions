class Solution {
    public int solve(int [] nums,int goal){
        if(goal<0){
            return 0;
        }
        int l=0,r=0;

        int count=0,sum=0;

        while(r<nums.length){
            sum+=nums[r];

            while(sum>goal){
                sum=sum-nums[l];
                l++;
            }

            count=count+(r-l+1);
            r++;
        }

        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return solve(nums,goal)-solve(nums,goal-1);
    }
}
