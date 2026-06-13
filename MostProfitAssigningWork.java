//approach 1
class Solution {
    record Pair(int profit,int diff){}
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int m=difficulty.length;
        int n=worker.length;
        int [] descWorker=Arrays.stream(worker)
                                .boxed()
                                .sorted(Comparator.reverseOrder())
                                .mapToInt(Integer::intValue).toArray();
        
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->Integer.compare(b.profit(),a.profit()));

        for(int i=0;i<m;i++){
            pq.offer(new Pair(profit[i],difficulty[i]));
        }

        int i=0;
        int totalProfit=0;

        while(i<n && !pq.isEmpty()){
            if(pq.peek().diff()>descWorker[i]){
                pq.poll();
            }
            else{
                totalProfit+=pq.peek().profit();
                i++;
            }
        }
        return totalProfit;
    }
}


//approach 2
class Solution {
    record Pair(int diff,int profit){}
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int m=difficulty.length;
        int n=worker.length;
        
        List<Pair>arr=new ArrayList<>();

        for(int i=0;i<m;i++){
            arr.add(new Pair(difficulty[i],profit[i]));
        }

        Collections.sort(arr,(a,b) -> Integer.compare(a.diff(),b.diff()));

        Arrays.sort(worker);

        int totalProfit=0;
        int j=0;  //pointing to arr

        int maxProfit=0;

        for(int i=0;i<n;i++){

            while(j<m && worker[i]>=arr.get(j).diff()){
                maxProfit=Math.max(maxProfit,arr.get(j).profit());
                j++;
            }
            totalProfit+=maxProfit;
        }
        return totalProfit;
    }
}
