class Solution {
    public int findMinArrowShots(int[][] points) {
        int n=points.length;

        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));

        int prevStart=points[0][0];
        int prevEnd=points[0][1];
        int count=1;

        for(int i=1;i<n;i++){
            int currStart=points[i][0];
            int currEnd=points[i][1];

            if(prevEnd<currStart){
                count++;
                prevStart=currStart;
                prevEnd=currEnd;
            }
            else{
                //overlap
                prevStart=Math.max(prevStart,currStart);
                prevEnd=Math.min(currEnd,prevEnd);
            }
        }
        return count;
    }
}
