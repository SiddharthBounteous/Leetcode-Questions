//approach 1
class Solution {
    int t[];
    public int solve(int idx,String s,int n){

        if(idx>=n){
            return 1;  //1 valid split
        }
        if(t[idx]!=-1){
            return t[idx];
        }
        

        if(s.charAt(idx)=='0'){
            return t[idx]=0;  //not possible to split
        }

        int only_ith_char=solve(idx+1,s,n);

        int ith_i_plus_1_char=0;

        if(idx+1<n && (s.charAt(idx)=='1' || (s.charAt(idx)=='2' && s.charAt(idx+1)<='6'))){
            ith_i_plus_1_char=solve(idx+2,s,n);
        }

        return t[idx]=ith_i_plus_1_char+only_ith_char;
    }
    public int numDecodings(String s) {
        int n=s.length();
        
        t=new int[n+1];

        Arrays.fill(t,-1);

        return solve(0,s,n);
    }
}

//approach 2
class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int [] t=new int[n+1];
        Arrays.fill(t,-1);

        //t[i]=> no. of ways to decode string s from i to n
        t[n]=1;

        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='0'){
                t[i]=0;
            }
            else{
                t[i]=t[i+1];

                if(i+1<n){
                    if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<='6')){
                        t[i]+=t[i+2];
                    }
                }

            }
        }

        return t[0];
    }
}
