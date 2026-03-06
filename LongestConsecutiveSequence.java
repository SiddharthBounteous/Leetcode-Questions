class Solution {
    public int longestConsecutive(int[] nums) {
        int maxi=0;
        Map<Integer,Boolean>mp=new HashMap<>();
        for(int num:nums){
            mp.put(num,Boolean.FALSE);
        }

        for(int num:nums){
            int currLen=1;

            int nextNum=num+1;

            while(mp.containsKey(nextNum) && mp.get(nextNum)==false){
                currLen++;
                mp.put(nextNum,Boolean.TRUE);
                nextNum++;
            }

            int prevNum=num-1;

            while(mp.containsKey(prevNum) && mp.get(prevNum)==false){
                currLen++;
                mp.put(prevNum,Boolean.TRUE);
                prevNum--;
            }

            maxi=Math.max(maxi,currLen);
        }

        return maxi;
    }
}
