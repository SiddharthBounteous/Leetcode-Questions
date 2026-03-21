class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>mp=new HashMap<>();
        int n=nums.length;
        int [] result=new int[2];

        for(int i=0;i<n;i++){
            int remaining=target-nums[i];

            if(mp.containsKey(remaining)){
                result[0]=i;
                result[1]=mp.get(remaining);
                break;
            }

            mp.put(nums[i],i);
        }

        return result;
    }
}
