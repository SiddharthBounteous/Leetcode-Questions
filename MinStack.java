//1st approach

class MinStack {
    public record Pair<K,V>(K first,V second){}
    Stack<Pair<Integer,Integer>>st=new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new Pair(val,val));
        }
        else{
            int mini=Math.min(val,st.peek().second);
            st.push(new Pair(val,mini));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().first;
    }
    
    public int getMin() {
        return st.peek().second;
    }
}

//2nd approach
class MinStack {
    Stack<Long>st=new Stack<>();
    long minVal=Long.MAX_VALUE;
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push((long)val);
            minVal=(long)val;
        }
        else{
            if(val<minVal){
                st.push((long)2*val-minVal);
                minVal=(long)val;
            }
            else{
                st.push((long)val);
            }
        }
    }
    
    public void pop() {
        if(st.peek()<minVal){
            minVal=2*minVal-st.peek();
        }
        st.pop();
    }
    
    public int top() {
        long top=st.peek();
        if(top<minVal){
            return (int)minVal;
        }
        return (int)top;
    }
    
    public int getMin() {
        return (int)minVal;
    }
}
