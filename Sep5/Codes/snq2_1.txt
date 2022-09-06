class MinStack {
    Stack<Integer> data;
    Stack<Integer> min;

    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        if(data.size() == 0){
            data.push(val);
            min.push(val);
        } else {
            data.push(val);
            if(val <= min.peek()){
                min.push(val);
            }
        }
    }
    
    public void pop() {
        if(!data.peek().equals(min.peek())){
            data.pop();
        } else {
            data.pop();
            min.pop();
        }
    }
    
    public int top() {
       return data.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */