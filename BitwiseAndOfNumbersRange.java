//1st approach
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift=0;

        while(left!=right){
            //longest common prefix
            left=(left>>1);
            right=(right>>1);
            shift++;
        }

        return (left<<shift);
    }
}

//2nd approach
class Solution {
    public int rangeBitwiseAnd(int left, int right) {

        while(right>left){
            right=(right)&(right-1);
        }

        return right;
    }
}
