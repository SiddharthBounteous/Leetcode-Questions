class Solution {
    int findLeftMost(int[] nums,int target,int n){
        int l=0,r=n-1;

        int leftMost=-1;

        while(l<=r){
            int mid=l+(r-l)/2;

            if(nums[mid]==target){
                leftMost=mid;
                r=mid-1;
            }
            else if(nums[mid]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return leftMost;
    }
    int findRightMost(int[] nums,int target,int n){
        int l=0,r=n-1;

        int rightMost=-1;

        while(l<=r){
            int mid=l+(r-l)/2;

            if(nums[mid]==target){
                rightMost=mid;
                l=mid+1;
            }
            else if(nums[mid]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return rightMost;
    }
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int result[]=new int[2];

        int left_most=findLeftMost(nums,target,n);
        int right_most=findRightMost(nums,target,n);

        result[0]=left_most;
        result[1]=right_most;

        return result;
    }
}
