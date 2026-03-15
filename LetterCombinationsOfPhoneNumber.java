class Solution {
    List<String>result=new ArrayList<>();
    void solve(Map<Character,String>mp,int idx,String digits,StringBuilder temp){
        if(idx>=digits.length()){
            result.add(temp.toString());
            return;
        }

        char ch=digits.charAt(idx);
        String str=mp.get(ch);

        for(int i=0;i<str.length();i++){
            temp.append(str.charAt(i));
            solve(mp,idx+1,digits,temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }

        Map<Character,String>mp=new HashMap<>();

        mp.put('2',"abc");
        mp.put('3',"def");
        mp.put('4',"ghi");
        mp.put('5',"jkl");
        mp.put('6',"mno");
        mp.put('7',"pqrs");
        mp.put('8',"tuv");
        mp.put('9',"wxyz");
        StringBuilder temp=new StringBuilder();

        solve(mp,0,digits,temp);

        return result;
    }
}
