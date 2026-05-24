class Solution {
    public int minCut(String s) {
        int n=s.length();

        boolean t[][]=new boolean[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(t[i],false);
        }

        //t[i][j]=>true/false  from i to j string (palindrome or not)

        for(int i=0;i<n;i++){
            t[i][i]=true;
        }

        //length>=2;
        for(int L=2;L<=n;L++){
            for(int i=0;i<n-L+1;i++){
                int j=i+L-1;

                if(L==2){
                    if(s.charAt(i)==s.charAt(j)){
                        t[i][j]=true;
                    }
                }
                else{
                    t[i][j]=((s.charAt(i)==s.charAt(j)) && t[i+1][j-1]);
                }
            }
        }

        int dp[]=new int[n];

        //dp[i]=min cuts required to split it into palindrome till ith index

        for(int i=0;i<n;i++){
            if(t[0][i]==true){  //0...i is palindrome
                dp[i]=0;  //no cuts required
            }
            else{
                dp[i]=Integer.MAX_VALUE;
                for(int k=0;k<i;k++){
                    if(t[k+1][i]==true && 1+dp[k]<dp[i]){
                        dp[i]=1+dp[k];
                    }
                }
            }
        }
        return dp[n-1]; //minimum cuts within 0....n-1 
    }
}
