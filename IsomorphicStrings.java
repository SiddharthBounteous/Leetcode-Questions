class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        Map<Character,Character>mp=new HashMap<>();

        for(int i=0;i<s.length();i++){
            char org=s.charAt(i);
            char rep=t.charAt(i);

            if(!mp.containsKey(org)){
                if(!mp.containsValue(rep)){
                    mp.put(org,rep);
                }
                else{
                    return false;
                }
            }
            else{
                char mappedChar=mp.get(org);
                if(mappedChar!=rep){
                    return false;
                }
            }
        }
        return true;
    }
}
