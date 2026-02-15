//brute force
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;

        for(int i=0;i<n;i++){
            if(gas[i]<cost[i]){
                continue;
            }

            int j=(i+1)%n;

            int costToMove=cost[i];
            int gasEarnedinNextStation=gas[j];

            int currGas=gas[i]-costToMove+gasEarnedinNextStation;


            while(j!=i){
                if(currGas<cost[j]){
                    break;
                }

                int costOfMovingFromcurrJ=cost[j];

                j=(j+1)%n;

                gasEarnedinNextStation=gas[j];

                currGas=currGas-costOfMovingFromcurrJ+gasEarnedinNextStation;
            }

            if(j==i){
                //completed
                return i;
            }
        }
        return -1;
    }
}

//optimized approach
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;

        int totalEarned=0;
        int totalExpense=0;

        for(int i=0;i<n;i++){
            totalEarned+=gas[i];
        }
        for(int i=0;i<n;i++){
            totalExpense+=cost[i];
        }

        if(totalEarned<totalExpense){
            return -1;
        }

        int resultIndex=0;

        int total=0;

        for(int i=0;i<n;i++){
            total+=gas[i]-cost[i];

            if(total<0){
                resultIndex=i+1;
                total=0;
            }
        }

        return resultIndex;
    }
}
