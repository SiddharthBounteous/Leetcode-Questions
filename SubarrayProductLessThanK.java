class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l=0,r=0;
        int count=0,prod=1;

        if(k<=1){
            return 0;
        }

        int n=nums.length;

        while(r<n){
            prod=prod*nums[r];

            while(prod>=k){
                prod=(prod/nums[l]);
                l++;
            }
            count=count+(r-l+1);
            r++;
        }

        return count;
    }
}
