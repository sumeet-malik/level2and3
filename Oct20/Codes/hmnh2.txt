class MedianFinder {
    PriorityQueue<Integer> second;
    PriorityQueue<Integer> first;
    int sz;
    
    public MedianFinder() {
        first = new PriorityQueue<>(Collections.reverseOrder());
        second = new PriorityQueue<>();
        sz = 0;
    }
    
    public void addNum(int num) {
        if(first.size() > 0 && num < first.peek()){
            first.add(num);
        } else {
            second.add(num);
        }
        
        if(second.size() - first.size() == 2){
            first.add(second.remove());
        } else if(first.size() - second.size() == 2){
            second.add(first.remove());
        }
    }
    
    public double findMedian() {
        if(second.size() > first.size()){
            return second.peek();
        } else if(first.size() > second.size()) {
            return first.peek();
        } else {
            return (second.peek() + first.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */