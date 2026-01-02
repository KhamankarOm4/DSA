class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minstack;


    public MinStack() {
     stack = new Stack<Integer>();
     minstack = new Stack<Integer>();    
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(val);
            minstack.push(val);
            return;
        }
        stack.push(val);
        if(val <= minstack.peek()){
            minstack.push(val);
            
        }
    }
    
    public void pop() {

        if(stack.isEmpty()){
            return;
        }

        if(stack.peek().equals(minstack.peek())){
            minstack.pop();
            stack.pop();
            return;
        }

        stack.pop();
        
    }
    
    public int top() {
        if(stack.isEmpty()){
            return -1;
        }

      return stack.peek();   
    }
    
    public int getMin() {
        if(minstack.isEmpty()){
            return -1;
        }
        return minstack.peek();
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