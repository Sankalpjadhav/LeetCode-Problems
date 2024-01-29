class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        // No need to check if we are performing pop operation before adding element into ds as in the constraint they have mentioned All the calls to pop and peek are valid.
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        return stack2.pop();
    }
    
    public int peek() {
        if(!stack2.isEmpty()){
            return stack2.peek();
        }

        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        return stack2.peek();
    }
    
    public boolean empty() {
        return (stack1.isEmpty() && stack2.isEmpty());
    }
}



/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

 /*
 Stack<Integer> input;
    Stack<Integer> output;
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        if(!output.isEmpty()){
            return output.pop();
        }
        // If empty
        while(!input.isEmpty()){
            output.push(input.pop());
        }
        return output.pop();
    }
    
    public int peek() {
        if(!output.isEmpty()){
            return output.peek();
        }
        // If empty
        while(!input.isEmpty()){
            output.push(input.pop());
        }
        return output.peek();
    }
    
    public boolean empty() {
        return (input.isEmpty() && output.isEmpty());
    }
 */