//by sorting each string
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>mp=new HashMap<>();
        List<List<String>>result=new ArrayList<>();

        int n=strs.length;

        for(int i=0;i<n;i++){
            String temp=strs[i];
            char [] arr=temp.toCharArray();

            Arrays.sort(arr);
            String sortedString=new String(arr);

            if(!mp.containsKey(sortedString)){
                mp.put(sortedString,new ArrayList<>());
            }
            mp.get(sortedString).add(temp);
        }

        mp.forEach((key,value)->{
            result.add(value);
        });

        return result;
    }
}

//without sorting
class Solution {
    String GenerateFunc(String word){
        int arr[]=new int[26];
        Arrays.fill(arr,0);

        char [] str=word.toCharArray();

        for(int i=0;i<str.length;i++){
            char ch=str[i];
            arr[ch-'a']++;
        }

        StringBuilder newWord=new StringBuilder();

        for(int i=0;i<26;i++){
            int freq=arr[i];
            newWord.append("#");
            newWord.append(freq);
        }

        return newWord.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>mp=new HashMap<>();
        List<List<String>>result=new ArrayList<>();

        int n=strs.length;

        for(int i=0;i<n;i++){
            String temp=strs[i];

            String newWord=GenerateFunc(temp);
            

            if(!mp.containsKey(newWord)){
                mp.put(newWord,new ArrayList<>());
            }
            mp.get(newWord).add(temp);
        }

        mp.forEach((key,value)->{
            result.add(value);
        });

        return result;
    }
}
