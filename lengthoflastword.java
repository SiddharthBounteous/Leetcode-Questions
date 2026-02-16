class Solution {
    public int lengthOfLastWord(String s) {
        String result=s.trim();

        char ans[]=result.toCharArray();
        int n=ans.length;

        return ans[n-1].length();
    }
}
