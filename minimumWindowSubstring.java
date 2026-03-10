class Solution {
    private boolean contains(int tMap[],int sMap[]){
        for(int i=0;i<256;i++){
            if(tMap[i]>sMap[i]){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int n=s.length();
        int tMap[]=new int[256];
        int sMap[]=new int[256];

        for(char ch:t.toCharArray()){
            tMap[ch]++;
        }
        int i=0,j=0;
        int minLen=Integer.MAX_VALUE;
        int minStart=0;

        while(j<n){
            sMap[s.charAt(j)]++;
            while(contains(tMap,sMap)){
                if(j-i+1<minLen){
                    minLen=j-i+1;
                    minStart=i;
                }
                sMap[s.charAt(i)]--;
                i++;
            }
            j++;
        }
        return minLen==Integer.MAX_VALUE ? "":s.substring(minStart,minStart+minLen);
    }
}
