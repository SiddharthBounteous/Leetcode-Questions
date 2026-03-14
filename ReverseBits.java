class Solution {
    public int reverseBits(int n) {
        if(n==0){
            return 0;
        }
        int result=0;
        for(int i=1;i<=32;i++){
            result=result<<1;
            int append=n&1;

            result=result | append;
            n=n>>1;
        }

        return result;
    }
}
