class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer>dq=new ArrayDeque<>();
        int n=nums.length;
        List<Integer>temp=new ArrayList<>();

        for(int i=0;i<n;i++){

            while(!dq.isEmpty() && dq.getFirst()<=i-k){
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[i]>nums[dq.getLast()]){
                dq.removeLast();
            }

            dq.add(i);

            if(i>=k-1){
                temp.add(nums[dq.getFirst()]);
            }
        }

        int [] result=temp.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();

        return result;
    }
}
