class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;

        int majority=nums[0];
        int count=1;

        for(int i=1;i<n;i++){
            if(count==0){
                majority=nums[i];
                count=1;
            }
            else if(majority==nums[i]){
                count++;
            }
            else{
                count--;
            }
        }

        return majority;
    }
}
