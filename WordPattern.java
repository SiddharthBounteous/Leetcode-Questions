class Solution {
    public boolean wordPattern(String pattern, String s) {
        String arr[]=s.split(" ");

        if(pattern.length()!=arr.length){
            return false;
        }
        Map<Character,String>mp=new HashMap<>();

        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);

            if(!mp.containsKey(ch)){
                if(!mp.containsValue(arr[i])){
                    mp.put(ch,arr[i]);
                }
                else{
                    return false;
                }
            }

            if(!mp.get(ch).equals(arr[i])){
                return false;
            }
        }
        return true;
    }
}
