//top down approach
class Solution {
    public int solve(int [] days,int [] costs,int idx,int n,int [] dp){
        if(idx>=n){
            return 0;
        }

        if(dp[idx]!=-1){
            return dp[idx];
        }

        //1 day pass
        int cost_1=costs[0]+solve(days,costs,idx+1,n,dp);

        //7 day pass
        int j=idx;
        int max_day=days[idx]+7;
        while(j<n && days[j]<max_day){
            j++;
        }

        int cost_7=costs[1]+solve(days,costs,j,n,dp);

        //30 day pass
        j=idx;
        max_day=days[idx]+30;
        while(j<n && days[j]<max_day){
            j++;
        }

        int cost_30=costs[2]+solve(days,costs,j,n,dp);

        return dp[idx]=Math.min(cost_1,Math.min(cost_7,cost_30));
    }
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        int dp[]=new int[365];

        Arrays.fill(dp,-1);

        return solve(days,costs,0,n,dp);
    }
}

//bottom up approach
class Solution {
    
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;

        Set<Integer>st=new HashSet<>();

        for(int i=0;i<n;i++){
            st.add(days[i]);
        }

        int last_day=days[n-1];
        int dp[]=new int[last_day+1];
        //dp[i]=min cost to travel till ith day
        dp[0]=0;

        for(int i=1;i<=last_day;i++){
            if(!st.contains(i)){
                dp[i]=dp[i-1];
                continue;
            }

            dp[i]=Integer.MAX_VALUE;
            int day_1_pass=costs[0]+dp[Math.max(i-1,0)];
            int day_7_pass=costs[1]+dp[Math.max(i-7,0)];
            int day_30_pass=costs[2]+dp[Math.max(i-30,0)];

            dp[i]=Math.min(day_1_pass,Math.min(day_7_pass,day_30_pass));
        }

        return dp[last_day];
    }
}
