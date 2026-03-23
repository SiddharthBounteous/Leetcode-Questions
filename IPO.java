class Solution {
    record Pair(int cap,int prf){}
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;

        List<Pair> sortedPair=new ArrayList<>();

        for(int i=0;i<n;i++){
            sortedPair.add(new Pair(capital[i],profits[i]));
        }

        Collections.sort(sortedPair,(a,b)->Integer.compare(a.cap(),b.cap()));

        int i=0;
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);

        while(k>0){
            while(i<n && sortedPair.get(i).cap()<=w){
                pq.add(sortedPair.get(i).prf());
                i++;
            }

            if(pq.isEmpty()){
                break;
            }

            w+=pq.poll();
            k--;
        }
        return w;
    }
}
