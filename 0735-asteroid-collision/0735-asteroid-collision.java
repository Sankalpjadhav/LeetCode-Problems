class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<asteroids.length;i++){
            int asteroid = asteroids[i];
            if(asteroid > 0 || stack.isEmpty()){
                stack.push(asteroid);
            }
            else{
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)){
                    stack.pop();
                }
                
                if(!stack.isEmpty() && stack.peek() == Math.abs(asteroid)){
                    stack.pop();
                }
                else{
                    if(stack.isEmpty() || stack.peek() < 0){
                        stack.push(asteroid);
                    }
                }
            }
        }
        
        if(stack.isEmpty()){
            return new int[]{};
        }
        
        int n = stack.size();
        int [] result = new int[n];
        for(int j=n-1;j>=0;j--){
            result[j] = stack.pop();
        }
        
        return result;
    }
}