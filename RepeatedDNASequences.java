class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n=s.length();
        if(n<=10){
            return new ArrayList<>();
        }
        Set<String> seen=new HashSet<>();
        Set<String> repeated=new HashSet<>();
        List<String>result=new ArrayList<>();
        
        for(int i=0;i<=n-10;i++){
            String sub=s.substring(i,i+10);
            if(seen.contains(sub)){
                repeated.add(sub);
            }
            seen.add(sub);
        }
        for(String it:repeated){
            result.add(it);
        }
        return result;
    }
}
