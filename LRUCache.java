//brute force
class LRUCache {
    record Pair(int first,int sec){}
    List<Pair>cache=new ArrayList<>();
    int n;

    public LRUCache(int capacity) {
        n=capacity;
    }
    
    public int get(int key) {
        for(int i=0;i<cache.size();i++){
            if(cache.get(i).first()==key){
                int val=cache.get(i).sec();

                Pair temp=cache.get(i);
                cache.remove(i);
                cache.add(temp);
                return val;
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        for(int i=0;i<cache.size();i++){
            if(cache.get(i).first()==key){
                cache.remove(i);
                cache.add(new Pair(key,value));
                return;
            }
        }
        if(cache.size()==n){
            cache.remove(0);
            cache.add(new Pair(key,value));
        }
        else{
            cache.add(new Pair(key,value));
        }
    }
}

//optimal approach
class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    Map<Integer,Node>mp=new HashMap<>();
    int n;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        n=capacity;
        mp=new HashMap<>();
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    public void removeNode(Node node){
        Node before=node.prev;
        Node after=node.next;

        before.next=after;
        after.prev=before;
    }

    public void addAfterHead(Node node){
        Node currentFirst=head.next;
        head.next=node;
        node.prev=head;

        node.next=currentFirst;
        currentFirst.prev=node;
    }

    public void makeRecentlyUsed(int key){
        Node node=mp.get(key);

        removeNode(node);
        addAfterHead(node);
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)){
            return -1;
        }
        makeRecentlyUsed(key);

        return mp.get(key).value;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node node=mp.get(key);
            node.value=value;
            makeRecentlyUsed(key);
            return;
        }
        if(mp.size()==n){
            Node lru=tail.prev;
            removeNode(lru);
            mp.remove(lru.key);
        }
        Node newNode=new Node(key,value);
        addAfterHead(newNode);
        mp.put(key,newNode);
        return;
    }
}
