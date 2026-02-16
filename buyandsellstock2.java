class Solution {
    int n;
    int t[][];
    int solve(int [] prices,int idx,int flag){
        if(idx>=n){
            return 0;
        }
        if(t[idx][flag]!=-1)
        {
            return t[idx][flag];
        }
        if(flag==0){
            int buy=solve(prices,idx+1,1)-prices[idx];
            int skip=solve(prices,idx+1,0);
            return t[idx][flag]=Math.max(buy,skip);
        }
        else{
            int sell=solve(prices,idx+1,0)+prices[idx];
            int skip=solve(prices,idx+1,1);
            return t[idx][flag]=Math.max(sell,skip);
        }
    }
    public int maxProfit(int[] prices) {
        
        n=prices.length;
        t=new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                t[i][j]=-1;
            }
        }
        return solve(prices,0,0);
    }
}
