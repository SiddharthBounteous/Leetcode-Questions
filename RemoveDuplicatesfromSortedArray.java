class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;

        int count=0;

        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                continue;
            }
            else{
                nums[count]=nums[i];
                count++;
            }
        }
        nums[count++] = nums[n - 1];
        return count;
    }
}
