class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;

        int max_so_far=nums[0];
        int curr_max=nums[0];

        for(int i=1;i<n;i++){
            curr_max=Math.max(nums[i],nums[i]+curr_max);
            max_so_far=Math.max(max_so_far,curr_max);
        }

        return max_so_far;
    }
}
