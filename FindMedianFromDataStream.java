class MedianFinder {
    PriorityQueue<Integer>rightQu=new PriorityQueue<>();
    PriorityQueue<Integer>leftQu=new PriorityQueue<>(Collections.reverseOrder());
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(leftQu.isEmpty() || num<leftQu.peek()){
            leftQu.add(num);
        }
        else{
            rightQu.add(num);
        }

        //maintain left heap size +1 greater than right or both have equal size
        if(leftQu.size()-rightQu.size()>1){
            rightQu.add(leftQu.poll());
        }
        else if(leftQu.size()<rightQu.size()){
            leftQu.add(rightQu.poll());
        }

    }
    
    public double findMedian() {
        double mean=0;
        if(leftQu.size()==rightQu.size()){
            mean=(leftQu.peek()+rightQu.peek())/2.0;
        }
        else{
            mean=leftQu.peek();
        }
        return mean;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
