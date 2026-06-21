class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        int n=arr.length;
        boolean []prev =new boolean[sum+1];  //t[i-1]
        boolean []curr =new boolean[sum+1];  //t[i]
        Arrays.fill(prev,false);
        Arrays.fill(curr,false);
        
        prev[0]=true;
        curr[0]=true;
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                boolean skip=prev[j];
                boolean take=false;
                
                if(arr[i-1]<=j){
                    take=prev[j-arr[i-1]];
                }
                
                curr[j]=(take || skip);
            }
            prev=curr.clone();
        }
        return prev[sum];
    }
}
