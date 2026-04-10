class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String>bankSt=new HashSet<>();
        Set<String>visited=new HashSet<>();

        for(int i=0;i<bank.length;i++){
            bankSt.add(bank[i]);
        }

        Queue<String>qu=new LinkedList<>();
        qu.offer(start);
        visited.add(start);
        int level=0;
        char [] arr={'A','C','G','T'};

        while(!qu.isEmpty()){
            int n=qu.size();

            while(n>0){
                String curr=qu.poll();

                if(curr.equals(end)){
                    return level;
                }

                for(char ch: arr){
                    for(int i=0;i<curr.length();i++){
                        StringBuilder sb=new StringBuilder(curr);
                        sb.setCharAt(i,ch);
                        String str=sb.toString();

                        if(!visited.contains(str) && bankSt.contains(str)){
                            visited.add(str);
                            qu.offer(str);
                        }
                    }
                }
                n--;
            }
            level++;
        }
        return -1;
    }
}
