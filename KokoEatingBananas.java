class Solution {
    private boolean solve(int[] piles,int bananas,int h){
        int actualHours=0;

        for(int x:piles){
            actualHours+=(x/bananas);

            if(x%bananas!=0){
                actualHours++;
            }
        }

        return actualHours<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;

        int low=1;
        int high=Integer.MIN_VALUE;

        for(int num:piles){
            high=Math.max(num,high);
        }

        while(low<high){
            int mid=low+(high-low)/2;

            if(solve(piles,mid,h)){
                //mid bananas per hour
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}
