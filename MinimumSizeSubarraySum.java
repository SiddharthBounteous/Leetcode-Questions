class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int minLen=Integer.MAX_VALUE;
        int currSum=0;

        int i=0,j=0;

        while(j<n){
            currSum+=nums[j];
            j++;

            while(currSum>=target){
                int currLen=j-i;
                minLen=Math.min(minLen,currLen);
                currSum-=nums[i];
                i++;
            }
        }

        return minLen==Integer.MAX_VALUE ? 0:minLen;
    }
}
