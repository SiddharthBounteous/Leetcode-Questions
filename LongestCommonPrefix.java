class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        StringBuilder result=new StringBuilder();

        Arrays.sort(strs);
        char[] first=strs[0].toCharArray();
        char[] last=strs[n-1].toCharArray();

        for(int i=0;i<first.length;i++){
            if(first[i]!=last[i]){
                break;
            }
            result.append(first[i]);
        }

        return result.toString();
    }
}
