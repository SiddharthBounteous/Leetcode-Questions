//1st approach
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();

        if(n>m){
            return false;
        }

        char [] arr1=s1.toCharArray();

        Arrays.sort(arr1);

        

        for(int i=0;i<=m-n;i++){
            String str=s2.substring(i,i+n);
            char [] arr2=str.toCharArray();
            Arrays.sort(arr2);

            if(Arrays.equals(arr1,arr2)){
                return true;
            }
        }

        return false;
    }
}

//2nd approach
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();

        if(n>m){
            return false;
        }

        int arr1[]=new int[26];
        int arr2[]=new int[26];

        Arrays.fill(arr1,0);
        Arrays.fill(arr2,0);

        for(char ch:s1.toCharArray()){
            arr1[ch-'a']++;
        }

        int i=0,j=0;

        while(j<m){
            arr2[s2.charAt(j)-'a']++;

            if(j-i+1>n){
                arr2[s2.charAt(i)-'a']--;
                i++;
            }

            if(Arrays.equals(arr1,arr2)){
                return true;
            }
            j++;
        }

        return false;
    }
}
