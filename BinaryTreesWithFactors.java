class Solution {
    int mod=1000000007;
    public int numFactoredBinaryTrees(int[] arr) {
        int n=arr.length;

        Arrays.sort(arr);

        Map<Integer,Long>mp=new HashMap<>();  //each single binary tree as root->key
        //no of binary having key as root->value
        mp.put(arr[0],1L);

        for(int i=1;i<n;i++){
            int root=arr[i];
            mp.put(root,mp.getOrDefault(root,0L)+1);
            for(int j=0;j<i;j++){
                int leftChild=arr[j];

                if(root%leftChild==0 && mp.containsKey(arr[i]/leftChild)){
                    long total=mp.get(leftChild)*mp.get(arr[i]/leftChild);
                    mp.put(root,(mp.getOrDefault(root,0L)+total)%mod);
                }
            }
        }

        long result=0;

        for(long val:mp.values()){
            result=(result+val)%mod;
        }

        return (int)result;
    }
}
