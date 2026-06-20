class Solution {
    int mod=1000000007;
    private int reverseNum(int num){
        int ans=0;

        while(num>0){
            int rem=num%10;
            ans=ans*10+rem;
            num=num/10;
        }
        return ans;
    }
    public int countNicePairs(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer>mp=new HashMap<>();
        int result=0;

        for(int i=0;i<n;i++){
            nums[i]=nums[i]-reverseNum(nums[i]);
        }

        for(int i=0;i<n;i++){
            if(mp.containsKey(nums[i])){
                result=(result+mp.get(nums[i]))%mod;
            }
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        return result;
    }
}
