class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int [] parr=new int[26];
        int [] sarr=new int[26];

        Arrays.fill(parr,0);
        Arrays.fill(sarr,0);

        List<Integer>result=new ArrayList<>();

        for(char c:p.toCharArray()){
            parr[c-'a']++;
        }

        for(int i=0;i<s.length();i++){
            sarr[s.charAt(i)-'a']++;

            if(i>=p.length()){
                sarr[s.charAt(i-p.length())-'a']--;
            }

            if(Arrays.equals(parr,sarr)){
                result.add(i-p.length()+1);
            }
        }
        return result;
    }
}
