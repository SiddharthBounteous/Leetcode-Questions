class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer>mp=new HashMap<>();
        mp.put(0,1);

        int currSum=0;
        int count=0;

        for(int i=0;i<n;i++){
            currSum+=nums[i];
            if(mp.containsKey(currSum-k)){
                count+=mp.get(currSum-k);
            }
            mp.put(currSum,mp.getOrDefault(currSum,0)+1);
        }

        return count;
    }
}
