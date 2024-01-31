class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int [] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i=n-1;i>=0;i--){
            int currentTemp = temperatures[i];

            while(!stack.isEmpty() && temperatures[stack.peek()] <= currentTemp){
                stack.pop();
            } 

            if(stack.isEmpty()){
                result[i] = 0;
            }
            else{
                result[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        return result;
    }
}