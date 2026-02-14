class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;

        int candy=n;
        int i=1;

        while(i<n){
            if(ratings[i]==ratings[i-1]){
                i++;
                continue;
            }

            //increasing slope
            int peak=0;
            if(ratings[i]>ratings[i-1]){
                peak++;
                candy+=peak;
                i++;

                if(i==n){
                    return candy;
                }
            }

            //decreasing slope
            int dip=0;

            if(i<n && ratings[i]<ratings[i-1]){
                dip++;
                candy+=dip;
                i++;
            }

            candy=candy-Math.min(peak,dip);
        }
        return candy;
    }
}