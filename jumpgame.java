//recursion
class Solution {
    int t[];
    boolean solve(int[] nums,int idx,int n){
        if(idx>=n-1){
            return true;
        }
        if(t[idx]==1){
            return true;
        }
        if(t[idx]==0){
            return false;
        }

        for(int i=1;i<=nums[idx];i++){
            if(solve(nums,idx+i,n)==true){
                t[idx]=1;
                return true;
            }
        }
        t[idx]=0;
        return false;
    }
    public boolean canJump(int[] nums) {
        t=new int[10001];
        Arrays.fill(t,-1);
        int n=nums.length;

        return solve(nums,0,n);
    }
}
//bottom up
class Solution {
    
    public boolean canJump(int[] nums) {
       int n=nums.length;

       boolean arr[]=new boolean[n];

       Arrays.fill(arr,false);

       //arr[i]=means mai i tak pahunch skata hoon
       arr[0]=true;

       for(int i=1;i<n;i++){
        for(int j=i-1;j>=0;j--){
            if(arr[j]==true && nums[j]+j>=i){
                arr[i]=true;
                break;
            }
        }
       }
       return arr[n-1];
    }
}
//

//smart approach(without dp)
class Solution {
    
    public boolean canJump(int[] nums) {
       int n=nums.length;

       int maxReachable=0;

       for(int i=0;i<n;i++){
        if(i>maxReachable){
            return false;
        }
        maxReachable=Math.max(maxReachable,i+nums[i]);
       }

       return true;
    }
}
