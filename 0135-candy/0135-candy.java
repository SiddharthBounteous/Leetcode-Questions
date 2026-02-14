class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;

        int LtoR[]=new int[n];
        int RtoL[]=new int[n];

        Arrays.fill(LtoR,1);
        Arrays.fill(RtoL,1);

        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                LtoR[i]=Math.max(LtoR[i],LtoR[i-1]+1);
            }
        }
        
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                RtoL[i]=Math.max(RtoL[i],RtoL[i+1]+1);
            }
        }

        int result=0;

        for(int i=0;i<n;i++){
            result+=Math.max(LtoR[i],RtoL[i]);
        }

        return result;
    }
}