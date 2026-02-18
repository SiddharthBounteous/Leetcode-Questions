//brute force(using arraylist)
class MyHashSet {

    ArrayList<Boolean>arr=new ArrayList<>();
    public MyHashSet() {
        int size=1000001;
        for (int i=0;i<size;i++) {
            arr.add(false);  
        }
    }
    
    public void add(int key) {
        arr.set(key,true);
    }
    
    public void remove(int key) {
        arr.set(key,false);
    }
    
    public boolean contains(int key) {
        return arr.get(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */


//optimized(to prevent collisions)
//1. open addressing  (put in adjacent bucket)(linear probing)
//2. separate chaining (creating a linked list inside arraylist)

//by separate chaining
//load factor=(no. of input)/(size of bucket) (if > 0.75 then we do re hashing)
//T.C.=O(n/m)
//S.C.=O(n/m)
class MyHashSet {

    int M;   //no. of buckets
    List<LinkedList<Integer>>buckets;

    int getIndex(int key){
        return key%M;
    }

    public MyHashSet() {
        M=15000;
        buckets=new ArrayList<>(M);
        

        for(int i=0;i<M;i++){
            buckets.add(new LinkedList<>());
        }
    }
    
    public void add(int key) {
        int index=getIndex(key);

        LinkedList<Integer>bucket=buckets.get(index);

        if(!bucket.contains(key)){
            bucket.add(key);
        }

    }
    
    public void remove(int key) {
        int index=getIndex(key);

        LinkedList<Integer>bucket=buckets.get(index);

        if(bucket.contains(key)){
            bucket.remove(Integer.valueOf(key));
        }
    }
    
    public boolean contains(int key) {
        int index=getIndex(key);

        LinkedList<Integer>bucket=buckets.get(index);
        return bucket.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
