class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character>st=new HashSet<>();

        int maxLen=0;
        int i=0;

        int n=s.length();

        for(int j=0;j<n;j++){
            
            while(st.contains(s.charAt(j))){
                st.remove(s.charAt(i));
                i++;
            }

            st.add(s.charAt(j));
            maxLen=Math.max(maxLen,j-i+1);
        }

        return maxLen;
    }
}
