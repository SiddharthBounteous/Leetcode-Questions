//dp approach
class Solution {
    int n;
    int t[];
    int solve(int[] nums,int idx){
        if(idx>=n-1){
            return 0;
        }
        if(nums[idx]==0){
            return Integer.MAX_VALUE;
        }
        if(t[idx]!=-1){
            return t[idx];
        }

        int mini=Integer.MAX_VALUE;

        for(int i=1;i<=nums[idx];i++){
            int next=solve(nums,idx+i);
            if(next!=Integer.MAX_VALUE){
                mini=Math.min(mini,next+1);
            }
        }
        return t[idx]=mini;
    }
    public int jump(int[] nums) {
        
        n=nums.length;
        t=new int[n];
        Arrays.fill(t,-1);

        return solve(nums,0);
    }
}

//greedy solution(range based)
class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int jumps=0;
        int l=0,r=0;


        while(r<n-1){
            int farthest=0;

            for(int i=l;i<=r;i++){
                farthest=Math.max(farthest,i+nums[i]);
            }

            l=r+1;
            r=farthest;
            jumps++;
        }

        return jumps;
    }
}
