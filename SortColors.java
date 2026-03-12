class Solution {
    private void swap(int pos1,int pos2,int nums[]){
        int temp=nums[pos1];
        nums[pos1]=nums[pos2];
        nums[pos2]=temp;
    }
    public void sortColors(int[] nums) {
        int n=nums.length;
        int start=0;
        int mid=0;
        int end=n-1;

        while(mid<=end){
            switch(nums[mid]){
                case 0:
                    swap(start,mid,nums);
                    start++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(mid,end,nums);
                    end--;
                    break;
            }
        }
    }
}
