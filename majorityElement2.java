class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;

        List<Integer>result=new ArrayList<>();
        int count1=0;
        int majority1=0;

        int count2=0;
        int majority2=0;

        for(int i=0;i<n;i++){
            if(nums[i]==majority1){
                count1++;
            }
            else if(nums[i]==majority2){
                count2++;
            }
            else if(count1==0){
                majority1=nums[i];
                count1=1;
            }
            else if(count2==0){
                majority2=nums[i];
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }
        int freq1=0;
        int freq2=0;

        for(int num:nums){
            if(num==majority1){
                freq1++;
            }
            else if(num==majority2){
                freq2++;
            }
        }

        if(freq1>Math.floor(n/3)){
            result.add(majority1);
        }
        if(freq2>Math.floor(n/3)){
            result.add(majority2);
        }

        return result;
    }
}
