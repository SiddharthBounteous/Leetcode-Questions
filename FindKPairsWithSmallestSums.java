class Solution {
    record Pair(int a,int b){};
    record Pair1(int num,Pair p){};
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair1>pq=new PriorityQueue<>((x,y)->Integer.compare(x.num,y.num));
        List<List<Integer>>result=new ArrayList<>();

        int m=nums1.length;
        int n=nums2.length;

        for(int i=0;i<Math.min(m,k);i++){
            int sum=nums1[i]+nums2[0];

            pq.offer(new Pair1(sum,new Pair(i,0)));
        }

        while(k>0 && !pq.isEmpty()){
            Pair1 curr=pq.poll();

            int i=curr.p.a;
            int j=curr.p.b;

            result.add(Arrays.asList(nums1[i],nums2[j]));

            if(j+1<n){
                int newSum=nums1[i]+nums2[j+1];
                pq.offer(new Pair1(newSum,new Pair(i,j+1)));
            }
            k--;
        }
        return result;
    }
}
