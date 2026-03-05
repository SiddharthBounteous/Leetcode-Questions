class Solution {
    long Operate(int n1,int n2,String token){
        long op=0;
        switch(token){
            case "+":
                op= n1+n2;
                break;
            case "-":
                op=n1-n2;
                break;
            case "*":
                op=(long)n1*(long)n2;
                break;
            default:
                op=n1/n2;
        }
        return op;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer>st=new Stack<>();

        for(String token:tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int n2=st.peek();
                st.pop();
                int n1=st.peek();
                st.pop();
                long result=Operate(n1,n2,token);
                st.push((int)result);
            }
            else{
                int num=Integer.parseInt(token);
                st.push(num);
            }
        }
        return st.peek();
    }
}
