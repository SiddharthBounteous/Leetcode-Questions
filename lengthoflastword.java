class Solution {
    public int lengthOfLastWord(String s) {
        String result=s.trim();

        char ans[]=result.toCharArray();
        int n=ans.length;

        int count=0;
        for(int i=n-1;i>=0;i--){
            if(ans[i]==' '){
                break;
            }
            count++;
        }
        return count;
    }
}
