class MinStack {
    // Using single stack: Very intuitive solution of storing element along with minimum at that time
    class Element{
        int value;
        int min;

        Element(int _value, int _min){
            value = _value;
            min = _min;
        }
    }

    Stack<Element> minStack;

    public MinStack() {
        minStack = new Stack<Element>();
    }
    
    public void push(int val) {
        if(minStack.isEmpty()){
            Element elem = new Element(val, val);
            minStack.push(elem);
        }
        else{
            Element existingElementOnStack = minStack.peek();
            Element elem;
            if(val < existingElementOnStack.min){
                elem = new Element(val, val);
            }
            else{
                // >=
                elem = new Element(val, existingElementOnStack.min);
            }
            minStack.push(elem);
        }
    }
    
    public void pop() {
        minStack.pop();
    }
    
    public int top() {
       return minStack.peek().value;
    }
    
    public int getMin() {
        return minStack.peek().min;
    }
}

/*
Using 2 stacks:

class MinStack {

    Stack<Integer> defaultStack;
    Stack<Integer> minStack;

    public MinStack() {
        defaultStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        defaultStack.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
        }
        else{
            if(val <= minStack.peek()){
                minStack.push(val);
            }
        }
    }
    
    public void pop() {
        int poppedElement = defaultStack.pop();
        if(poppedElement == minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        return defaultStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

*/

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */