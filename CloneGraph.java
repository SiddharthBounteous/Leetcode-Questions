//dfs
class Solution {
    public void dfs(Node node,Node clone_node,Map<Node,Node>mp){
        for(Node neigh:node.neighbors){
            if(!mp.containsKey(neigh)){
                Node clone=new Node(neigh.val);
                mp.put(neigh,clone);
                clone_node.neighbors.add(clone);
                dfs(neigh,clone,mp);
            }
            else{
                clone_node.neighbors.add(mp.get(neigh));
            }
        }
    }
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        //clone the given node
        Node clone_node=new Node(node.val);

        //clone its neighbours and recursively its neighbours
        Map<Node,Node>mp=new HashMap<>();

        mp.put(node,clone_node);
        dfs(node,clone_node,mp);

        return clone_node;
    }
}

//bfs
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public void bfs(Queue<Node>qu, Map<Node,Node>mp){

        while(!qu.isEmpty()){
            Node node=qu.poll();
            Node clone_node=mp.get(node);

            for(Node neigh:node.neighbors){
                if(!mp.containsKey(neigh)){
                    Node clone=new Node(neigh.val);
                    mp.put(neigh,clone);
                    clone_node.neighbors.add(clone);
                    qu.offer(neigh);
                }
                else{
                    clone_node.neighbors.add(mp.get(neigh));
                }
            }
        }
    }
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        //clone the given node
        Node clone_node=new Node(node.val);

        //clone its neighbours and recursively its neighbours
        Map<Node,Node>mp=new HashMap<>();

        mp.put(node,clone_node);
        
        Queue<Node>qu=new LinkedList<>();
        qu.offer(node);
        bfs(qu,mp);
        return clone_node;
    }
}
