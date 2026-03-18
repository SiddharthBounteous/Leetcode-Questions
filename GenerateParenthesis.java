class Solution {
    private void solve(int n,List<String>result,int open,int close,StringBuilder curr){

        //base case
        if(curr.length()==n*2){
            result.add(curr.toString());
            return;
        }

        if(open<n){
            solve(n,result,open+1,close,curr.append("("));
            curr.deleteCharAt(curr.length()-1);
        }
        if(close<open){
            solve(n,result,open,close+1,curr.append(")"));
            curr.deleteCharAt(curr.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String>result=new ArrayList<>();
        StringBuilder curr=new StringBuilder();

        solve(n,result,0,0,curr);

        return result;
    }
}
