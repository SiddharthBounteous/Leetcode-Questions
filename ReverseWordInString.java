class Solution {
    public String reverseWords(String s) {
        int n=s.length();

        StringBuilder ans=new StringBuilder();
        StringBuilder str=new StringBuilder(s);
    
        str.reverse();

        for(int i=0;i<n;i++){
            StringBuilder word=new StringBuilder();

            while(i<n && str.charAt(i)!=' '){
                word.append(str.charAt(i));
                i++;
            }

            word.reverse();

            if(word.length()>0){
                ans.append(" ");
                ans.append(word);
            }
        }

        return ans.toString().substring(1);
    }
}
