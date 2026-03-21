class Solution {
    public boolean isPalindrome(String s) {

        int n=s.length();
        int i=0,j=n-1;
        char ch1;
        char ch2;
        String str=s.toLowerCase();

        while(i<=j){
            ch1=str.charAt(i);
            ch2=str.charAt(j);
            if(Character.isLetterOrDigit(ch1) && Character.isLetterOrDigit(ch2)){
                if(ch1!=ch2){
                    return false;
                }
                i++;
                j--;
            }
            else if(!Character.isLetterOrDigit(ch1)){
                i++;
            }
            else if(!Character.isLetterOrDigit(ch2))
            {
                j--;
            }
            else{
                return false;
            }
        
        }

        return true;
    }
}
