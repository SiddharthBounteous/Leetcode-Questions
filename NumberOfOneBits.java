//1st approach
class Solution {
    public int hammingWeight(int n) {
        int count=0;
        for(int i=31;i>=0;i--){
            if(((n>>i)&1)==1){
                count++;
            }
        }

        return count;
    }
}

//2nd approach
//T.C.=O(k)  where k is the no. of 1 bits
class Solution {
    public int hammingWeight(int n) {
        int count=0;
        while(n>0){
            n=n&(n-1);
            count++;
        }

        return count;
    }
}

//3rd approach
//T.C.=O(log2(n))
class Solution {
    public int hammingWeight(int n) {
        int count=0;
        while(n>0){
            if(n%2==1){
                count++;
            }
            n=n/2;
        }

        return count;
    }
}

//4th approach
class Solution {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
