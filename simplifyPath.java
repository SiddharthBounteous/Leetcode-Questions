class Solution {
    public String simplifyPath(String path) {
        String [] arr=path.split("/");

        Stack<String>st=new Stack<>();
        for(String it:arr){
            
            if(it.equals("") || it.equals(".")){
                continue;
            }
            else if(!it.equals("..")){
                st.push(it);
            }
            else{
                if(!st.isEmpty()){
                    st.pop();
                }
            }
        }
        if(st.isEmpty()){
            return "/";
        }

        String result="";
        while(!st.isEmpty()){
            result="/"+st.peek()+result;
            st.pop();
        }
        return result;
    }
}
