class Solution {
    public int[][] merge(int[][] intervals) {

        if(intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));

        int n=intervals.length;
        List<int[]>result=new ArrayList<>();

        result.add(intervals[0]);

        for(int i=1;i<n;i++){
    
                int arr[]=result.get(result.size()-1);
                int y=arr[1];  //end time of previous interval
                // compare y with current interval start time
                if(i>=1 && intervals[i][0]<=y){
                    //overlap
                    arr[1]=Math.max(y,intervals[i][1]);
                }
                else{
                    result.add(intervals[i]);
                }
            
        }
        return result.toArray(new int[result.size()][]);
    }
}
