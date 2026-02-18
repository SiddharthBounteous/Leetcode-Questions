class Solution {
    public String convert(String s, int numRows) {
        String [] res=new String[numRows];

        for(int i=0;i<numRows;i++){
            res[i]="";
        }

        int i=0;
        while(i<s.length()){
            for(int index=0;index<numRows && i<s.length();index++){
                res[index]+=s.charAt(i++);
            }
            for(int index=numRows-2;index>0 && i<s.length();index--){
                res[index]+=s.charAt(i++);
            }
        }

        String result="";
        for(String it:res){
            result+=it;
        }
        return result;
    }
}
