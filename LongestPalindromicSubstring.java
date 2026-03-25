class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();

        if(n<2){
            return s;
        }

        int start=0;
        int end=0;
        int maxLen=1;

        for(int i=0;i<n;i++){
            //for even
            int l=i-1;
            int r=i;

            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if(r-l+1>maxLen){
                    maxLen=r-l+1;
                    start=l;
                    end=r;
                }
                l--;
                r++;
            }
            //for odd
            l=i-1;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if(r-l+1>maxLen){
                    maxLen=r-l+1;
                    start=l;
                    end=r;
                }
                l--;
                r++;
            }
        }
        return s.substring(start,end+1);
    }
}
