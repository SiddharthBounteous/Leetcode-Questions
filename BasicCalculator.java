class Solution {
    public int calculate(String s) {
        Stack<Integer>st=new Stack<>();

        int n=s.length();

        int num=0;
        int result=0;
        int sign=1;

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(Character.isDigit(ch)){
                num=num*10+(ch-'0');
            }
            else if(ch=='+'){
                result+=num*(sign);
                num=0;
                sign=1;
            }
            else if(ch=='-'){
                result+=num*(sign);
                num=0;
                sign=-1;
            }
            else if(ch=='('){
                st.push(result);
                st.push(sign);
                result=0;
                num=0;
                sign=1;
            }
            else if(ch==')'){
                result+=num*(sign);   //inside bracket result added
                num=0;

                int stack_sign=st.peek();
                st.pop();
                int stack_num=st.peek();
                st.pop();

                result=result*(stack_sign);
                result+=stack_num;
            }
        }
        result+=num*(sign);
        return result;
    }
}
